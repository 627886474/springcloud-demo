package com.zl.product.utils;

import com.zl.product.dto.Result;

/**
 * @Auther: le
 * @Date: 2018/7/20 15:09
 * @Description:
 */
public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setData(object);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }
}
