package org.maxwell.hmredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 21:55
 */
@MapperScan("org.maxwell.hmredis.mapper")
@EnableAspectJAutoProxy
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    //@Bean
    //public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory connectionFactory) {
    //    RedisTemplate<String, T> template = new RedisTemplate<>();
    //    //设置连接工厂
    //    template.setConnectionFactory(connectionFactory);
    //    //创建json序列化工具
    //    GenericJackson2JsonRedisSerializer jsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
    //    //设置key的序列化
    //    template.setKeySerializer(RedisSerializer.string());
    //    template.setHashKeySerializer(RedisSerializer.string());
    //    template.setValueSerializer(jsonRedisSerializer);
    //    template.setHashValueSerializer(jsonRedisSerializer);
    //    return template;
    //}


}
