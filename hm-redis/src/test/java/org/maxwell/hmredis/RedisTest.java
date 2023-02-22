package org.maxwell.hmredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.maxwell.hmredis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 21:59
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testString() {
        redisTemplate.opsForValue().set("name", "Maxwell");
    }

    @Test
    void testObj() {
        redisTemplate.opsForValue().set("user:mao", new User("dakhj", 123));
        User o = (User) redisTemplate.opsForValue().get("user:mao");
        System.out.println(o);
    }


    @Test
    void testStrTemplate() throws JsonProcessingException {

        User jackson = new User("Jackson", 45);
        String string = objectMapper.writeValueAsString(jackson);

        stringRedisTemplate.opsForValue().set("user:jackson", string);
        String get = stringRedisTemplate.opsForValue().get("user:jackson");

        User user = objectMapper.readValue(get, User.class);
        System.out.println(user);

    }

}
