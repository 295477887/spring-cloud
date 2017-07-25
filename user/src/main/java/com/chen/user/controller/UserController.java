package com.chen.user.controller;

import com.chen.user.bean.User;
import com.chen.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/7/25.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository repo ;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id)
    {
        return repo.findOne(id);
    }
}
