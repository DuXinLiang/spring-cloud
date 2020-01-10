package com.baige.controller;

import com.baige.pojo.User;
import com.baige.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("user/{id}")
    @HystrixCommand(fallbackMethod = "getUserByIdFallBack",
            commandProperties = {
                @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String getUserById(@PathVariable("id") Long id) throws JsonProcessingException {
        System.out.println("消费者被调用了");
        User user = userService.getUserById(id);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(user);
    }

    public String getUserByIdFallBack(Long id){
        return "用户太多了，请耐心等待";
    }
}