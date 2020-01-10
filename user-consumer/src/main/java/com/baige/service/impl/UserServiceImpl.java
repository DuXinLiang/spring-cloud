package com.baige.service.impl;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.baige.pojo.User;
import com.baige.client.IUserClient;
import com.baige.service.IUserService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements IUserService {

   /* @Autowired
    private RestTemplate restTemplate;*/

    /*@Autowired
    private DiscoveryClient discoveryClient;*/

    @Autowired
    private IUserClient userClient;

    @Override
    public User getUserById(Long id) {
        // 根据服务名称获取服务列表
        // List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 因为user-service只有一个实例
        // ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息
        // String host = instance.getHost();
        // int port = instance.getPort();
        // String url = "http://user-service/user/" + id;
        // return restTemplate.getForObject(url, User.class);

        String userStr = userClient.getUserById(id);
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try{
            user = mapper.readValue(userStr, User.class);
        } catch (IOException e){
            e.printStackTrace();
        }
        return user;
    }
}