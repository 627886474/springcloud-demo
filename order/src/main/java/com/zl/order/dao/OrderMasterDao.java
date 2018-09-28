package com.zl.order.dao;

import com.zl.order.model.OrderMaster;

/**
 * @Auther: le
 * @Date: 2018/7/23 15:49
 * @Description:
 */
public interface OrderMasterDao {
    /**
     * 订单详情
     * @param orderMaster
     * @return
     */
    Integer insertOrderMaster(OrderMaster orderMaster);
}
