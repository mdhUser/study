package org.maxwell.wrongcase.nosqluse_26.mysqlvsredis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/15 14:34
 */
@Configuration
public class RedissonConfiguration {

    @Bean
    public RedissonClient redissonClient() throws IOException {
        Config config = Config.fromYAML(this.getClass().getClassLoader().getResourceAsStream("redisson-config.yml"));
        //Config config = new Config();
        //config.useSingleServer().setAddress("redis://59.36.170.213:6379").setPassword("Maxwell");
        return Redisson.create(config);
    }

}
