package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    @Autowired
    RedisService redisService;

    @GetMapping("/set")
    public String setRedis(String key,String value){
        redisService.set(key,value,10);
        return "add success";
    }
    @GetMapping("/get")
    public String getRedis(String key){
        return redisService.getValue(key);
    }
}
