package com.jnu.gulimall.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @date : [2022/9/15 0:56]
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedissonTest {

    @Resource
    private RedissonClient redisson;

    @Test
    public void test(){
        System.out.println(redisson);
    }

}