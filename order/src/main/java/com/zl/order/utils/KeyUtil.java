package com.zl.order.utils;

import java.util.Random;

/**
 * @Auther: le
 * @Date: 2018/7/23 14:47
 * @Description:
 */
public class KeyUtil {

    /**
     * 唯一的主键
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis()+String.valueOf(number);
    }
}
