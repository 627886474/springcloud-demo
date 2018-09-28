package com.zl.product.dao;

import com.zl.product.model.ProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * @Auther: le
 * @Date: 2018/7/15 16:54
 * @Description:
 */
public interface ProductInfoDao {

    /**
     * 通过上架状态查询商品
     * @param status
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer status);


    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    ProductInfo findById(String productId);

    int updateStock(@Param("productId") String productId,
                    @Param("orderDetailQuantity") Integer orderDetailQuantity);
}
