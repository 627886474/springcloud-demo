package com.zl.order.service;

import com.zl.order.dto.OrderDTO;

/**
 * @Auther: le
 * @Date: 2018/7/24 15:07
 * @Description:
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO createOrder(OrderDTO orderDTO);
}
