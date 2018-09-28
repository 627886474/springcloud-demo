package com.zl.order.service.impl;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.zl.order.client.ProductClient;
import com.zl.order.dao.OrderDetailDao;
import com.zl.order.dao.OrderMasterDao;
import com.zl.order.dto.OrderDTO;
import com.zl.order.dto.productcommon.DecreaseStockInput;
import com.zl.order.dto.productcommon.ProductInfoOutput;
import com.zl.order.enums.OrderStatusEnum;
import com.zl.order.enums.PayStatusEnum;
import com.zl.order.exception.OrderException;
import com.zl.order.model.OrderDetail;
import com.zl.order.model.OrderMaster;
import com.zl.order.service.OrderService;
import com.zl.order.utils.KeyUtil;
import com.zl.order.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: le
 * @Date: 2018/7/24 15:07
 * @Description:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDetailDao orderDetailDao;

    @Autowired
    OrderMasterDao orderMasterDao;

    @Autowired
    ProductClient productClient;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderDTO orderDTO) {
        //随机唯一id
        String orderId = KeyUtil.genUniqueKey();
        //商品信息
        try {
            List<String> productList = orderDTO.getOrderDetailList().stream()
                    .map(OrderDetail::getProductId)
                    .collect(Collectors.toList());
            // 调用product 开放的rest接口，获取商品信息
            List<ProductInfoOutput> productInfoOutputs = productClient.listForOrder(productList);
            //计算总价
            BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
            //订单入库
            for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
                for (ProductInfoOutput productInfo : productInfoOutputs) {
                    if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                        orderAmout = productInfo.getProductPrice()
                                .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                                .add(orderAmout);

                        BeanUtils.copyProperties(productInfo, orderDetail);
                        orderDetail.setOrderId(orderId);
                        orderDetail.setDetailId(KeyUtil.genUniqueKey());
                        orderDetail.setCreateTime(null);
                        orderDetail.setUpdateTime(null);
                        orderDetailDao.insertOrderDetail(orderDetail);
                    }
                }
            }

            //扣库存
            List<DecreaseStockInput> decreaseStockInputs = orderDTO.getOrderDetailList()
                    .stream().map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                    .collect(Collectors.toList());

            // 调用product 开放的rest接口，扣库存
            productClient.decreaseStock(decreaseStockInputs);

            OrderMaster orderMaster = new OrderMaster();
            orderDTO.setOrderId(orderId);
            BeanUtils.copyProperties(orderDTO, orderMaster);

            orderMaster.setOrderAmount(orderAmout);
            orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
            orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
            orderMaster.setCreateTime(new Date());
            orderMaster.setUpdateTime(new Date());

            orderMasterDao.insertOrderMaster(orderMaster);

        } catch (Exception e) {
            throw new OrderException("创建订单失败:" + e.getMessage());
        }
        return orderDTO;
    }
}
