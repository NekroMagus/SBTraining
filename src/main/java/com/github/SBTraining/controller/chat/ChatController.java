package com.github.SBTraining.controller.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

     @GetMapping("/client")
     public String chat() {
         return "chat";
     }

}
