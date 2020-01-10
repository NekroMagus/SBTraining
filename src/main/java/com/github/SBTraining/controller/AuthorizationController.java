package com.github.SBTraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AuthorizationController {
    @GetMapping("/login")
    public String authorization() {
        return "login";
    }
}