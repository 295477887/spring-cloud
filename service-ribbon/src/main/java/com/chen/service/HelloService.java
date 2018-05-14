package com.chen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ChenJie
 * @date 2018/5/11
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;


    /**
     * SERVICE-HI为服务名，已经注册到同一个eureka
     * */
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=", String.class);
    }

}
