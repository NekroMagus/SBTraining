package com.github.SBTraining.controller.teapot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TeapotCrudController {

    @GetMapping("/crudTeapot")
    public String getHtmlPage() {
        return "crudTeapot";
    }

}
