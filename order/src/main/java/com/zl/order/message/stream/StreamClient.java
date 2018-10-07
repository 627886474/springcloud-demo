package com.zl.order.message.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Auther: le
 * @Date: 2018/10/6 19:23
 * @Description:
 */
public interface StreamClient {


    @Input("streamMessage")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();
}
