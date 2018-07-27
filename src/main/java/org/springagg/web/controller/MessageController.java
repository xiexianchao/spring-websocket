package org.springagg.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springagg.service.Sender;
import org.springagg.websocket.TextMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

@Controller
@RequestMapping("message")
public class MessageController {

    @Bean
    public TextMessageHandler textMessageHandler() {
        return new TextMessageHandler();
    }

    @RequestMapping
    public String view() {
        return "message";
    }

    @Autowired
    private Sender sender;

    @RequestMapping("send")
    @ResponseBody
    public String send(HttpServletRequest request, @RequestParam("username") String username) {
        TextMessage message = new TextMessage(request.getParameter("message"));
        textMessageHandler().sendMessageToUser(username, message);
       // sender.sendMessage("mqMessage",request.getParameter("message"));
        return "true";
    }
}
