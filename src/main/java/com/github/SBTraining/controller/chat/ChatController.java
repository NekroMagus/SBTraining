package com.github.SBTraining.controller.chat;

import com.github.SBTraining.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {



    @MessageMapping("/message")
    @SendTo("/chat/topic")
    public Message message(Message message) throws Exception {
        return new Message(message.getNameUserFrom(),message.getValue());
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}