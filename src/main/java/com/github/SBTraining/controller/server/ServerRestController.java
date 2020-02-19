package com.github.SBTraining.controller.server;

import com.github.SBTraining.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

   @MessageMapping("/serverGet")
   public Message getMessage(Message message) {
       return message;
   }

   @GetMapping("/serverSend")
   @SendTo("/clientGet")
   public Message sendMessage(Message message) {
       return message;
   }
}
