package com.chen.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
     * HystrixCommand 断路方法
     * */
    @HystrixCommand(fallbackMethod="hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=", String.class);
    }

    public String hiError(String name){
        return "hi "+name+", ribbon server error!";
    }

}
