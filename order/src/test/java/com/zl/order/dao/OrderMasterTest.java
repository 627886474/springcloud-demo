package com.zl.order.dao;

import com.zl.order.OrderApplication;
import com.zl.order.enums.OrderStatusEnum;
import com.zl.order.enums.PayStatusEnum;
import com.zl.order.model.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: le
 * @Date: 2018/7/24 14:54
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderMasterTest {

    @Autowired
     OrderMasterDao orderMasterDao;

    @Test
    public void insertOrderMasterTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("可乐");
        orderMaster.setBuyerPhone("123123123");
        orderMaster.setBuyerAddress("软件");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        Integer effectnum = orderMasterDao.insertOrderMaster(orderMaster);
        System.out.println(effectnum);
    }
}
