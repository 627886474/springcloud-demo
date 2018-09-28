package com.zl.product.service;

import com.zl.product.common.DecreaseStockInput;
import com.zl.product.common.ProductInfoOutput;
import com.zl.product.model.ProductInfo;

import java.util.List;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:04
 * @Description:
 */
public interface ProductService {

    /**
     * 查询所有上架商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList);

}
