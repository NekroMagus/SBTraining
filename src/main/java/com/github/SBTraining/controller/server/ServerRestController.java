package com.github.SBTraining.controller.server;

import com.github.SBTraining.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ServerRestController {

    @MessageMapping("/server")
    @SendTo("/topic/messages")
    public Message sendMessage() {
        Message message = new Message();
        message.setText("Hello");
        return message;
    }

}