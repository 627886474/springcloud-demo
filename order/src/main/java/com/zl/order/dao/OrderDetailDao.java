package com.zl.order.dao;

import com.zl.order.model.OrderDetail;

/**
 * @Auther: le
 * @Date: 2018/7/23 15:48
 * @Description:
 */
public interface OrderDetailDao {
    /**
     * 订单描述
     * @param orderDetail
     * @return
     */
    Integer insertOrderDetail(OrderDetail orderDetail);
}
