package org.maxwell.wrongcase.cache_23.invalid;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 16:49
 */
@SpringBootApplication
public class CacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(CacheApplication.class, args);
    }

    @Bean
    public RedissonClient redissonClient() throws IOException {
        Config config = Config.fromYAML(new File("wrong-case/src/main/resources/redisson-config.yml"));
        return Redisson.create(config);
    }


}
