package com.zl.product.common;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2018/9/21 14:51
 * @Description:
 */
@Data
public class DecreaseStockInput {
    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput(){}

    public DecreaseStockInput(String productId,Integer productQuantity){
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
