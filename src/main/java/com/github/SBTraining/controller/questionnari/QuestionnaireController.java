package com.github.SBTraining.controller.questionnari;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionnaireController {

    @GetMapping("/quest")
    public String questionnaire() {
        return "questionnaire";
    }

}
