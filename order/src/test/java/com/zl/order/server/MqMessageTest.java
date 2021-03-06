package com.zl.order.server;

import com.netflix.discovery.converters.Auto;
import com.zl.order.OrderApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Auther: le
 * @Date: 2018/9/30 16:21
 * @Description:
 */
@Component
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class MqMessageTest {
    @Autowired
    private AmqpTemplate amqpTemplate;



    @Test
    public void processComputerTest(){
        amqpTemplate.convertAndSend("myOrder","computer","now "+new Date());
    }

    @Test
    public void processFruitTest(){
        amqpTemplate.convertAndSend("myOrder","fruit","now "+new Date());
    }

}
