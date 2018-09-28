package com.zl.order.utils;

import com.zl.order.dto.ResultVo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: le
 * @Date: 2018/7/23 15:09
 * @Description:
 */
public class ResultUtil {
    public static Object ok(){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("erroCode",0);
        obj.put("errMsg","成功");
        return obj;
    }

    public static Object ok(Object data){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("errCode",0);
        obj.put("errMsg","成功");
        obj.put("data",data);
        return obj;
    }

    public static Object ok(String msg,Object data){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("errCode",0);
        obj.put("errMsg",msg);
        obj.put("data",data);
        return obj;
    }

    public static ResultVo success(Object object){
        ResultVo result = new ResultVo();
        result.setData(object);
        result.setCode(0);
        result.setMsg("成功");
        return result;
    }

    public static Object fail(Object object){
        Map<String,Object> obj = new HashMap<>();
        obj.put("errCode",1);
        obj.put("errMsge",object);
        return obj;
    }

    public static Object fail(int errCode, String errMsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errCode", errCode);
        obj.put("errMsge", errMsg);
        return obj;
    }

    public static Object badArgument(){
        return fail(401, "参数不对");
    }


    public static Object badArgumentValue(){
        return fail(402, "参数值不对");
    }

    public static Object unlogin(){
        return fail(501, "请登录");
    }

    public static Object serious(){
        return fail(502, "系统内部错误");
    }

    public static Object unsupport(){
        return fail(503, "业务不支持");
    }


}
