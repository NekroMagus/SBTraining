package com.github.SBTraining.service.questionnaire;

import com.github.SBTraining.dao.QuestionnaireDao;
import com.github.SBTraining.model.Answer;
import com.github.SBTraining.model.Question;
import com.github.SBTraining.model.Questionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class QuestionnaireService {

    static Logger logger = Logger.getLogger(QuestionnaireService.class.getName());

    @Autowired
    private QuestionnaireDao questionnaireDao;

    public void addQuestionnaire(Questionnaire questionnaire) {
        questionnaireDao.deleteAll();
        questionnaireDao.save(questionnaire);
        logger.info(questionnaireDao.findAll().get(0).getId() + "");
    }

    public void addQuestion(Question question) {
        Questionnaire questionnaire = questionnaireDao.findById(question.getIdQuestionnaire());
        if (questionnaire.getTree().isEmpty()) {
            questionnaire.getTree().add(question);
            questionnaire.setMainQuestion(question);
            questionnaire.setCurrentQuestion(question);
            update(questionnaire);
            logger.info(questionnaireDao.findById(questionnaire.getId()) + "");

        } else {
            if (question.getId() < questionnaire.getCurrentQuestion().getId()) {
                if (questionnaire.getCurrentQuestion().getQuestionLeft() == null) {

                    question.setSuperQuestion(questionnaire.getCurrentQuestion());
                    questionnaire.getTree().add(question);
                    questionnaire.getCurrentQuestion().setQuestionLeft(question);
                    questionnaire.setCurrentQuestion(questionnaire.getMainQuestion());
                    update(questionnaire);

                } else if (question.getId() < questionnaire.getCurrentQuestion().getQuestionLeft().getId()) {

                    questionnaire.setCurrentQuestion_two(questionnaire.getCurrentQuestion());
                    questionnaire.setCurrentQuestion(questionnaire.getCurrentQuestion_two().getQuestionLeft());
                    addQuestion(question);

                }
            } else if (question.getId() > questionnaire.getCurrentQuestion().getId()) {
                if (questionnaire.getCurrentQuestion().getQuestionRight() == null) {

                    question.setSuperQuestion(questionnaire.getCurrentQuestion());
                    questionnaire.getTree().add(question);
                    questionnaire.getCurrentQuestion().setQuestionRight(question);
                    questionnaire.setCurrentQuestion(questionnaire.getMainQuestion());
                    update(questionnaire);

                } else if (question.getId() > questionnaire.getCurrentQuestion().getQuestionRight().getId()) {

                    questionnaire.setCurrentQuestion_two(questionnaire.getCurrentQuestion());
                    questionnaire.setCurrentQuestion(questionnaire.getCurrentQuestion_two().getQuestionRight());
                    addQuestion(question);

                }
            }
        }
    }

    public Question findQuestionById(long id, long idQuestionnaire) {
        Question result = new Question();
        Questionnaire questionnaire = questionnaireDao.findById(idQuestionnaire);
        if (id == questionnaire.getCurrentQuestion().getId()) result = questionnaire.getCurrentQuestion();

        else if (id < questionnaire.getCurrentQuestion().getId()) {

            if (questionnaire.getCurrentQuestion().getQuestionLeft() != null && id == questionnaire.getCurrentQuestion().getQuestionLeft().getId()) {

                result = questionnaire.getCurrentQuestion().getQuestionLeft();

            } else if (questionnaire.getCurrentQuestion().getQuestionLeft() != null && id < questionnaire.getCurrentQuestion().getQuestionLeft().getId()) {

                questionnaire.setCurrentQuestion_two(questionnaire.getCurrentQuestion());
                questionnaire.setCurrentQuestion(questionnaire.getCurrentQuestion_two().getQuestionLeft());
                findQuestionById(id, idQuestionnaire);

            }
        } else if (id > questionnaire.getCurrentQuestion().getId()) {

            if (questionnaire.getCurrentQuestion().getQuestionRight() != null && id == questionnaire.getCurrentQuestion().getQuestionRight().getId()) {

                result = questionnaire.getCurrentQuestion().getQuestionRight();

            } else if (questionnaire.getCurrentQuestion().getQuestionRight() != null && id > questionnaire.getCurrentQuestion().getQuestionRight().getId()) {

                questionnaire.setCurrentQuestion_two(questionnaire.getCurrentQuestion());
                questionnaire.setCurrentQuestion(questionnaire.getCurrentQuestion_two().getQuestionRight());
                findQuestionById(id, idQuestionnaire);

            }
        }
        return result;

    }

    public boolean checkQuestion(Answer answer) {
        if (findQuestionById(answer.getId(), answer.getIdQuestionnaire()).getAnswer() != null &&
                findQuestionById(answer.getId(), answer.getIdQuestionnaire()).getAnswer().equals(answer.getAnswer()))
            return true;
        else return false;
    }

    public void update(Questionnaire questionnaire) {
        Questionnaire dbQuestionnaire = questionnaireDao.findById(questionnaire.getId());
        dbQuestionnaire.setCurrentQuestion_two(questionnaire.getCurrentQuestion_two());
        dbQuestionnaire.setCurrentQuestion(questionnaire.getMainQuestion());
        dbQuestionnaire.setMainQuestion(questionnaire.getMainQuestion());
        dbQuestionnaire.setTree(questionnaire.getTree());
        questionnaireDao.save(dbQuestionnaire);
    }

}

