package org.maxwell.wrongcase.connection_04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/13 11:16
 */
@Slf4j
@Configuration
public class RedisConfig {


    private static final String HOST = "59.36.170.213";
    private static final int PORT = 6379;
    private static Jedis jedis = new Jedis(HOST, PORT);
    private static final String AUTH = "Maxwell";


    @Bean("jedisPool")
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(6);
        jedisPoolConfig.setMinIdle(2);
        jedisPoolConfig.setMaxTotal(10);
        //设置请求超时时间
        jedisPoolConfig.setMaxWaitMillis(10000);
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, HOST, PORT, 5000, AUTH);
        log.info("JedisPool连接成功：{} \t port:{}", HOST, PORT);
        return jedisPool;
    }


    @PostConstruct
    public void init() {
        jedis.auth("Maxwell");
        Assert.isTrue("OK".equals(jedis.set("a", "1")), "set a = 1 is OK");
        Assert.isTrue("OK".equals(jedis.set("b", "2")), "set b = 2 is OK");
    }

    public static Jedis getJedis() {
        return jedis;
    }
}
