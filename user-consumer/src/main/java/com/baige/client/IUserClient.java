package com.baige.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface IUserClient {

    @GetMapping("user/{id}")
    String getUserById(@PathVariable("id") Long id);
}