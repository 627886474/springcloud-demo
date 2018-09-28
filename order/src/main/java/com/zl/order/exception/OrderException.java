package com.zl.order.exception;

import com.zl.order.enums.ResultEnum;

/**
 * @Auther: le
 * @Date: 2018/7/23 15:41
 * @Description:
 */
public class OrderException extends RuntimeException    {
    private Integer code;

    public OrderException(String message){
        super(message);
    }

    public OrderException(Integer code,String message){
        super(message);
        this.code = code;
    }
    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code =resultEnum.getCode();
    }
}
