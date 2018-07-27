package org.springagg.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springagg.websocket.TextMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.TextMessage;

public class MyMessageListener {
    private static final Logger logger = LoggerFactory.getLogger(MyMessageListener.class);
    @Bean
    public TextMessageHandler textMessageHandler(){
        return new TextMessageHandler();
    }

    @Autowired
    private TextMessageHandler textMessageHandler;

    public void getMessage(String message){
        System.out.println("收到消息:"+message);
        logger.info("获得消息:" + message);
        TextMessage textMessage = new TextMessage(message);
        textMessageHandler.sendMessageToUsers(textMessage);
    }
}
