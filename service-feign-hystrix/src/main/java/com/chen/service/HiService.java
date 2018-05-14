package com.chen.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: ChenJie
 * @date 2018/5/14
 * 调用feign接口service-hi服务
 * fallback 调用降级类，HiErrorService实现HiService
 */
@Service
@FeignClient(value="service-hi",fallback=HiErrorService.class)
public interface HiService {

    @RequestMapping(value="hi",method= RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value="name") String name);
}
