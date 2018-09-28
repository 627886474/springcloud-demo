package com.zl.product.enums;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:09
 * @Description:
 */

/**
 * 商品上、下架状态
 */
public enum ProductStatusEnum {
    UP(0,"上架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
