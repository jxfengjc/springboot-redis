package com.example.demo.service;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    public void set(String key,Object object,long time){
        if(object instanceof String){
            setString(key,(String)object);
        }
        if(object instanceof Set){
            setSet(key,(Set<String>)object);
        }
        stringRedisTemplate.expire(key, time, TimeUnit.MINUTES);
    }
    private void setSet(String key,Set<String> value){
        for(String str :value){
            stringRedisTemplate.opsForSet().add(key,str);
        }
    }
    private  void setString(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    public  String getValue(String key){
       return stringRedisTemplate.opsForValue().get(key);
    }

}
