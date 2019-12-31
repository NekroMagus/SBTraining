package com.github.SBTraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/html")
    public String getHtmlPage() {
        return "index";
    }
}
