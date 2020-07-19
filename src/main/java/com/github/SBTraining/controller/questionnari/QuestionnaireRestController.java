package com.github.SBTraining.controller.questionnari;

import com.github.SBTraining.model.Answer;
import com.github.SBTraining.model.Question;
import com.github.SBTraining.model.Questionnaire;
import com.github.SBTraining.service.questionnaire.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /**
     * check answer is correct
     * @param answer - answer object from user
     * @return boolean result , true if answer is correct , false if not
     */

    @PostMapping("/checkQuestion")
    public boolean checkQuestion(@RequestBody Answer answer) {
        return service.checkQuestion(answer);
    }

    /**
     * add Question
     * @param question - question object which will add to list
     * @return responseEntity which contains message and http status
     */

    @PostMapping("/addQuestion")
    public ResponseEntity addQuestion(@RequestBody Question question) {
        service.addQuestion(question);
        log.info("question added, question" + question.toString());
        return new ResponseEntity("question added", HttpStatus.OK);
    }

    /**
     * add questionnaire
     * @param questionnaire - questionnaire object which will add to data base
     * @return  responseEntity which contains message and http status
     */

    @GetMapping("/addQuestionnaire")
    public ResponseEntity addQuestionnaire(@RequestBody Questionnaire questionnaire) {
        service.addQuestionnaire(questionnaire);
        log.info("questionnaire added");
        return new ResponseEntity("questionnaire added",HttpStatus.OK);
    }

}
