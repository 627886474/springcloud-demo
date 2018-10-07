package com.zl.order.controller;

import com.zl.order.message.stream.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Auther: le
 * @Date: 2018/10/6 19:29
 * @Description:
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMessage")
    public void process(){
        streamClient.output().send(MessageBuilder.withPayload("now :"+new Date()).build());
    }

}
