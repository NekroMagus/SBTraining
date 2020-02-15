package com.github.SBTraining.controller.teapot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TeapotPagesController {

    @GetMapping("/teapot/{id}")
    public String getTeapotPage(@PathVariable("id") long id) {
        return "teapotPage";
    }

    @GetMapping("/main")
    public String getRecommendationsPage() {
        return "recommendations";
    }
}
