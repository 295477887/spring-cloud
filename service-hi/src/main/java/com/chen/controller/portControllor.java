package com.chen.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ChenJie
 * @date 2018/5/8
 */
@RestController
public class portControllor {
    Logger logger = LoggerFactory.getLogger(portControllor.class);

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
        return "service-hi " + name + ",i am from port : " + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    @RequestMapping("/hello")
    public String callHome(@RequestParam String name){
        return restTemplate.getForObject("http://localhost:8082/hi?name="+name, String.class);
    }






    @RequestMapping("/chen")
    public String port(
                       @RequestParam String signature,
                       @RequestParam String timestamp,
                       @RequestParam String nonce,
                       @RequestParam String echostr
    ){
        logger.info("signature={}",signature);
        logger.info("timestamp={}",timestamp);
        logger.info("nonce={}",nonce);
        logger.info("echostr={}",echostr);
        return echostr;
    }

}
