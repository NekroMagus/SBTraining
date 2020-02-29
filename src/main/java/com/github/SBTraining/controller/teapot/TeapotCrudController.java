package com.github.SBTraining.controller.teapot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class TeapotCrudController {


    //TODO: should be only 1 page with Teapot crud(for admin) and 1 page About Teapot(find by id)

    @GetMapping("/crudTeapot")
    public String getHtmlPage() {
        return "crudTeapot";
    }

    @GetMapping("/getAllTeapots")
    public String getAllTeapots() {
        return "allTeapots";
    }

}
