package com.jnu.gulimall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zr
 * @date 2021/11/11 21:14
 */
@Component
public class RedissonConfig {
    /**
     * 所有对Redisson的操作都是通过redissonClient对象
     */
//    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://110.40.220.85:6379");
        config.useSingleServer().setPassword("");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
