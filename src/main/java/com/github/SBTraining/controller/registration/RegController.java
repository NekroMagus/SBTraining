package com.github.SBTraining.controller.registration;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {

     @GetMapping("/regPage")
     public String registration() {
         return "registration";
     }

}
