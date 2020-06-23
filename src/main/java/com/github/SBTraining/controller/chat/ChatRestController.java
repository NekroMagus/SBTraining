package com.github.SBTraining.controller.chat;

import com.github.SBTraining.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ChatRestController {

    @MessageMapping("/message")
    @SendTo("/chat/messages")
    public Message getMessages(@RequestBody Message message) {
        System.out.println(message);
        return message;
    }

}