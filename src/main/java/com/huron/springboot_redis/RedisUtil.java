package com.huron.springboot_redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings("all")
public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    public long ttl(String key,TimeUnit timeUnit){
        return stringRedisTemplate.getExpire(key,timeUnit);
    }

    public  boolean expire(String key,long timeout,TimeUnit timeUnit){
        return stringRedisTemplate.expire(key,timeout,timeUnit);
    }

    public String getSet(String key,String value){
        return stringRedisTemplate.opsForValue().getAndSet(key,value);
    }

    public boolean del(String key){
        return stringRedisTemplate.delete(key);
    }

    public void hset(String key,String field,Object value){
        stringRedisTemplate.opsForHash().put(key,field,value);
    }

    public String hget(String key,String field){
        return (String)stringRedisTemplate.opsForHash().get(key,field);
    }
}
