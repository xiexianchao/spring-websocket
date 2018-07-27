package org.springagg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("sender")
public class Sender {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

   /* @Autowired
    @Qualifier(value="redisTemplate2")*/

    @Resource(name="redisTemplate")
    @Qualifier(value="redisTemplate")
    private RedisTemplate redisTemplate;

    public void sendMessage(String channel,String message){
        System.out.println("发送消息:" + message);
        logger.info("发送消息:" + message);
        redisTemplate.convertAndSend(channel,message);
    }
}
