package org.springagg.job;

import org.quartz.DisallowConcurrentExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springagg.util.SpringContextUtil;
import org.springagg.websocket.TextMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;

@DisallowConcurrentExecution
public class RedisJob{
    private static final Logger logger = LoggerFactory.getLogger(RedisJob.class);

    @Resource(name="redisTemplate2")
    private RedisTemplate redisTemplate;

    @Bean
    public TextMessageHandler textMessageHandler() {
        return new TextMessageHandler();
    }

    public void execute() {
        if(redisTemplate == null){
            redisTemplate  = (RedisTemplate) SpringContextUtil.getBean("redisTemplate2");
        }
        String total = (String)redisTemplate.opsForValue().get("total");
        logger.info("获取total:" + total);
        textMessageHandler().sendMessageToXieChao(new TextMessage("总金额:"+total));
    }
}
