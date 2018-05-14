package com.chen.service;

import org.springframework.stereotype.Service;

/**
 * @author: ChenJie
 * @date 2018/5/14
 */
@Service
public class HiErrorService implements HiService {
    @Override
    public String sayHiFromClientOne(String name) {
        return "hi " + name +", feign server is error !";
    }
}
