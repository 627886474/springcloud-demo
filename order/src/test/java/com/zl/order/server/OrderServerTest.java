package com.zl.order.server;

import com.zl.order.OrderApplication;
import com.zl.order.dto.OrderDTO;
import com.zl.order.enums.OrderStatusEnum;
import com.zl.order.enums.PayStatusEnum;
import com.zl.order.model.OrderMaster;
import com.zl.order.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: le
 * @Date: 2018/7/25 14:57
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderServerTest {
    @Autowired
    OrderService orderService;

    @Test
    public void orderServiceTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("1234567");
        orderDTO.setBuyerName("可乐");
        orderDTO.setBuyerPhone("123123123");
        orderDTO.setBuyerAddress("软件");
        orderDTO.setOrderAmount(new BigDecimal(2.5));
        orderDTO.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderDTO.setPayStatus(PayStatusEnum.WAIT.getCode());

        OrderDTO res = orderService.createOrder(orderDTO);
        System.out.println(res.getBuyerAddress());
    }
}
