package com.github.SBTraining.controller.chat;

import com.github.SBTraining.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class ChatController {

    static Logger log = Logger.getLogger(ChatController.class.getName());

    @MessageMapping("/message")
    @SendTo("/chat/topic")
    public Message message(Message message) throws Exception {
        log.info("message sent to topic , message:" + message.getValue());
        return new Message(message.getNameUserFrom(),message.getValue());
    }

    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }
}