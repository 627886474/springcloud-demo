package com.zl.order.dto.productcommon;

import lombok.Data;

/**
 * @Auther: le
 * @Date: 2018/9/28 15:17
 * @Description:
 */
@Data
public class DecreaseStockInput {
    /*扣库存*/
    private String productId;
    /*商品id*/
    private Integer productQuantity;

    public DecreaseStockInput(){}

    public DecreaseStockInput(String productId,Integer productQuantity){
        this.productId = productId ;
        this.productQuantity = productQuantity ;
    }
}
