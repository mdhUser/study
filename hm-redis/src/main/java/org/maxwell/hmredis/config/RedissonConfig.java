package org.maxwell.hmredis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://59.36.170.213:6379").setPassword("Maxwell");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }


    @Bean
    public RedissonClient redissonClient1() {
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://59.36.170.213:6380");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }


    @Bean
    public RedissonClient redissonClient2() {
        // 配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://59.36.170.213:6381");
        // 创建RedissonClient对象
        return Redisson.create(config);
    }

}
