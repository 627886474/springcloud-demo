package com.zl.product.dto;

/**
 * @Auther: le
 * @Date: 2018/7/15 17:18
 * @Description:
 */

/**
 * 返回给客户的基类
 * @param <T>
 */
public class Result<T> {
    /*错误码*/
    private Integer code;
    /*错误信息*/
    private String msg;
    /*返回给客户的信息，数据格式不一定，所以使用泛型*/
    private T data;

    public Result(){}

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }
}
