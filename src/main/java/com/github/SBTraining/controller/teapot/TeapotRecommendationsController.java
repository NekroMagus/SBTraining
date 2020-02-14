package com.github.SBTraining.controller.teapot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TeapotRecommendationsController {

    @GetMapping("/recommendations")
    public String recommendations() {
        return "recommendations";
    }
}
