package com.chen.movie.controller;

import com.chen.movie.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: ChenJie
 * @Description:
 * @Date 2017/7/25
 * @Modified by:
 */
@RestController
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public UserEntity getUser(@PathVariable Long id)
    {
        return restTemplate.getForObject("http://127.0.0.21:7900/user/"+id,UserEntity.class);
    }
}

