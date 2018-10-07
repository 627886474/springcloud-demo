package com.zl.order.message.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: le
 * @Date: 2018/10/6 19:26
 * @Description:
 */

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener("myMessage")
    public void processMessage(Object message){
        log.info("StreamReceiver message:{}",message);
    }

}
