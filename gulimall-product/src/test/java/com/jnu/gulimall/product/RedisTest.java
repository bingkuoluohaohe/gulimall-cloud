package com.jnu.gulimall.product;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @createTime : [2022/9/12 10:13]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("", 6379);
        jedis.auth("");
        jedis.select(0);
        System.out.println(jedis);
        jedis.set("name", "zhangsan");
    }

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testSpringDataRedis() {
        Person person = new Person("张三", "男", 18);
        redisTemplate.opsForValue().set("name", JSON.toJSONString(person));
    }

    @Test
    public void testHash() {
        redisTemplate.opsForHash().put("gulimall:user-1","name","张三");
        redisTemplate.opsForHash().put("gulimall:user-1","age","18");
        redisTemplate.opsForHash().put("gulimall:user-2","name","李四");
        redisTemplate.opsForHash().put("gulimall:user-2","age","18");

        Map<Object, Object> entries = redisTemplate.opsForHash().entries("gulimall:user-1");
        System.out.println(entries);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private String name;
        private String sex;
        private Integer age;
    }

}