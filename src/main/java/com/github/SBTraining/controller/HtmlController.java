package com.github.SBTraining.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class HtmlController {

    @GetMapping("/crud")
    public String getCrudPage() {
        return "crud";
    }

    @GetMapping("/getAllTeapots")
    public String getAllTeapots() {return "allTeapots";}
}
