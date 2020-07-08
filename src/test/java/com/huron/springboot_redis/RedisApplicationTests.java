package com.huron.springboot_redis;

import com.huron.springboot_redis.SpringbootRedisApplication;
import com.huron.springboot_redis.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class RedisApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void setGetTest(){
        redisUtil.set("name","shiyanlou");
        Assert.assertEquals("shiyanlou",redisUtil.get("name"));
        redisUtil.del("name");
    }


}
