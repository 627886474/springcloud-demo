package com.zl.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: le
 * @Date: 2018/9/26 22:23
 * @Description:
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "product server";
    }
}
