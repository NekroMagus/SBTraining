package com.github.SBTraining.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {

    @GetMapping("/")
    public String helloController() {
        return "Hi";
    }
}
