package com.zl.order.dto.productcommon;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Auther: le
 * @Date: 2018/9/27 14:16
 * @Description:
 */
@Data
public class ProductInfoOutput {
    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;


    /** 库存. */
    private Integer productStock;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;


    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;
}
