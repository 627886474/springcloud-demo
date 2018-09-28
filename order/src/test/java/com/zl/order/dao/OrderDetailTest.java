package com.zl.order.dao;

import com.netflix.discovery.converters.Auto;
import com.zl.order.OrderApplication;
import com.zl.order.model.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @Auther: le
 * @Date: 2018/7/23 16:31
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderDetailTest {

    @Autowired
    OrderDetailDao orderDetailDao;

    @Test
    public void insertOrderDetailTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("2");
        orderDetail.setPrdocuIcon("/image");
        orderDetail.setDetailId("12367");
        orderDetail.setProductId("157875196366160022");
        orderDetail.setProductName("shangp");
        orderDetail.setProductPrice(new BigDecimal(0.02));
        orderDetail.setProductQuantity(2);

        int effectNum = orderDetailDao.insertOrderDetail(orderDetail);
        System.out.println(effectNum);
    }

}
