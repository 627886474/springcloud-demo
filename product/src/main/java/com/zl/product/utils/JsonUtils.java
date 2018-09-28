package com.zl.product.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Auther: le
 * @Date: 2018/7/20 15:08
 * @Description:
 */
public class JsonUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 转Json
     * @param object
     * @return
     */
    public static String toJson(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
