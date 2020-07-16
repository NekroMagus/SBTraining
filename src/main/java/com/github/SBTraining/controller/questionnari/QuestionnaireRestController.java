package com.github.SBTraining.controller.questionnari;

import com.github.SBTraining.model.Answer;
import com.github.SBTraining.model.Question;
import com.github.SBTraining.model.Questionnaire;
import com.github.SBTraining.service.questionnaire.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;


@RestController
public class QuestionnaireRestController {

    static Logger log = Logger.getLogger(QuestionnaireRestController.class.getName());

    @Autowired
    private QuestionnaireService service;

    @PostMapping("/checkQuestion")
    public boolean checkQuestion(@RequestBody Answer answer) {
        return service.checkQuestion(answer);
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question) {
        service.addQuestion(question);
        log.info("question added, question" + question.toString());
        return "question added";
    }

    @GetMapping("/addQuestionnaire")
    public String addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        service.addQuestionnaire(questionnaire);
        log.info("questionnaire added");
        return "questionnaire added";
    }

}
