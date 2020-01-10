package com.baige.controller;

import com.baige.pojo.User;
import com.baige.service.IUserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("user/{id}")
    public String getUserById(@PathVariable("id") Long id) throws JsonProcessingException {
        System.out.println("==>服务被调用");
        User user = userService.getUserById(id);
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(user);
    }
}