package com.example.demo.com.gyx.receiver;

import com.example.demo.com.gyx.client.StreamClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 * @description Created by IntelliJ IDEA.
 * @date 2019/4/9
 */
@Component
/**
 * 自定义消息通道绑定
 */
@EnableBinding(value = {StreamClient.class})
public class FirstReceiver {
    private Logger logger = LoggerFactory.getLogger(FirstReceiver.class);

    /**
     * StreamListener 消息中间件上数据流的事件监听器
     * 当StringClient 渠道发动端的绑定者发送信息时
     * StringClient 对应的渠道接收端绑定者就会接收消息
     * @param message
     */
    @StreamListener(StreamClient.INPUT)
//    @SendTo(StreamClient.OUTPUT)
    //反馈一个ack给发送者
    public void reciver(String message){
        logger.info("StreamReceiver message : {}",message);
    }

}
