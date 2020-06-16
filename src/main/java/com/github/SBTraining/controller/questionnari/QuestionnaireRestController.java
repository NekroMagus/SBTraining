package com.github.SBTraining.controller.questionnari;

import com.github.SBTraining.dao.QuestionnaireDao;
import com.github.SBTraining.model.Answer;
import com.github.SBTraining.model.Question;
import com.github.SBTraining.model.Questionnaire;
import com.github.SBTraining.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionnaireRestController {

    @Autowired
    private QuestionnaireService service;

    @PostMapping("/checkQuestion")
    public boolean checkQuestion(@RequestBody Answer answer) {
        return service.checkQuestion(answer);
    }

    @PostMapping("/addQuestion")
    public void addQuestion(@RequestBody Question question) {
        service.addQuestion(question);
    }

    @GetMapping("/addQuestionnaire")
    public void addQuestionnaire() {
        service.addQuestionnaire(new Questionnaire());
    }

}
