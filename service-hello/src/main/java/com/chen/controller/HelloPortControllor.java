package com.chen.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ChenJie
 * @date 2018/5/8
 */
@RestController
public class HelloPortControllor {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public AlwaysSampler defaultSampler(){
        return new AlwaysSampler();
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String port(@RequestParam String name){
        if(RandomUtils.nextInt(10) < 5){
            throw new RuntimeException("我出异常了");
        }
        return "service-hello " + name + ",i am from port : " + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    @RequestMapping("/hello")
    public String callHome(@RequestParam String name){
        Map map = new HashMap<String,String>();
        map.put("name",name);
        return restTemplate.getForObject("http://localhost:8081/hi?name={name}", String.class, map);

    }

}
