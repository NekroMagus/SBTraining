package com.github.SBTraining.restcontroller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRestController {

    @GetMapping("/")
    public String helloController() {
        return "Hi";
    }

}
