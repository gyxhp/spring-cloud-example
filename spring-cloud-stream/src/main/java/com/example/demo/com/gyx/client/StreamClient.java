package com.example.demo.com.gyx.client;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * 消息通道定义，两个端口，输入输出，用来传递消息
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/9
 */
@Component
public interface StreamClient {
    String INPUT = "firstInput";
    String OUTPUT = "firstOutput";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();

}
