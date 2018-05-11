package com.chen.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ChenJie
 * @date 2018/5/8
 */
@RestController
public class portControllor {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getPort")
    public String port(@RequestParam String name){
        return "hi " + name + ",i am from port : " + port;
    }

}
