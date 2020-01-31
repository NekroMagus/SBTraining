package com.github.SBTraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TeapotPageController {

    @GetMapping("/teapot/{id}")
    public String teapotPage(@PathVariable("id") long id) {
        return "teapotPage";
    }

}
