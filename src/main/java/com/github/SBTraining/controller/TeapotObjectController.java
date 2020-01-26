package com.github.SBTraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TeapotObjectController {

    @GetMapping("/teapot/{id}")
    public String teapotPage(@PathVariable("id") long id) {
        return "teapotPage";
    }
}
