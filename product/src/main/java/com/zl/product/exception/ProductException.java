package com.zl.product.exception;

import com.zl.product.enums.ResultEnum;

/**
 * @Auther: le
 * @Date: 2018/9/21 15:09
 * @Description:
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
