package com.baige;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class UserZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserZuulApplication.class, args);
    }
}
