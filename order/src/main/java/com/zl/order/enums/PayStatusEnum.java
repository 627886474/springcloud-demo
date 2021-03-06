package com.zl.order.enums;

/**
 * @Auther: le
 * @Date: 2018/7/23 15:37
 * @Description:
 */
public enum  PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
            ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
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
