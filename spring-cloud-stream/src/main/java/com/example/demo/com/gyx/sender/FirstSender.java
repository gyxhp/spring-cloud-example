package com.example.demo.com.gyx.sender;

import com.example.demo.com.gyx.client.StreamClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/9
 */
@RestController
public class FirstSender {
    private Logger logger = LoggerFactory.getLogger(FirstSender.class);

    @Autowired
    private StreamClient streamClient;

    @GetMapping(value = {"send"})
    public void send(String message){
        logger.info("消息准备发送！");
        streamClient.output().send(MessageBuilder.withPayload(message).build());
        logger.info("发送完毕！");
    }

}
