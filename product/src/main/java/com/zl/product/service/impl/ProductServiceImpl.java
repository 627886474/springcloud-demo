package com.zl.product.service.impl;

import com.zl.product.common.DecreaseStockInput;
import com.zl.product.common.ProductInfoOutput;
import com.zl.product.dao.ProductInfoDao;
import com.zl.product.enums.ProductStatusEnum;
import com.zl.product.enums.ResultEnum;
import com.zl.product.exception.ProductException;
import com.zl.product.model.ProductInfo;
import com.zl.product.service.ProductService;
import com.zl.product.utils.JsonUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:06
 * @Description:
 */

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 查询上架商品
     * @return
     */
    @Override
    public List<ProductInfo> findUpAll() {
        //获取上架枚举标识
        Integer status = ProductStatusEnum.UP.getCode();
        //通过dao层查询数据库
        List<ProductInfo> productInfoList = productInfoDao.findByProductStatus(status);
        return productInfoList;
    }

    @Override
    public List<ProductInfoOutput> findList(List<String> productIdList) {
        return productInfoDao.findByProductIdIn(productIdList).stream()
                .map(e ->{
                    ProductInfoOutput output = new ProductInfoOutput();
                    BeanUtils.copyProperties(e, output);
                    return output;
                }).collect(Collectors.toList());
    }


    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList =decreaseStockProcess(decreaseStockInputList);
        //发送mq消息
        List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
            ProductInfoOutput output = new ProductInfoOutput();
            BeanUtils.copyProperties(e, output);
            return output;
        }).collect(Collectors.toList());
        amqpTemplate.convertAndSend("productInfo", JsonUtils.toJson(productInfoOutputList));

    }

    @Transactional
    @Override
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList){
        List<ProductInfo> productInfoList = new LinkedList<>();
        for (DecreaseStockInput decreaseStockInput:decreaseStockInputList){
            ProductInfo productInfo = productInfoDao.findById(decreaseStockInput.getProductId());

            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoDao.updateStock(productInfo.getProductId(),decreaseStockInput.getProductQuantity());
            productInfoList.add(productInfo);
        }

        return productInfoList;
    }


}
