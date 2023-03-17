package org.maxwell.wrongcase.nosqluse_26;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/15 15:42
 */
@Slf4j
@RequestMapping("nosql")
@RestController
public class NosqlSpeedController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("redis")
    public void redis() {
        //使用随机的Key来查询Value，结果应该等于PAYLOAD
        Assert.assertEquals(stringRedisTemplate.opsForValue().get("item" + (ThreadLocalRandom.current().nextInt(CommonMistakesApplication.ROWS) + 1)), CommonMistakesApplication.PAYLOAD);
    }

    @GetMapping("mysql")
    public void mysql() {
        //根据随机name来查data，name字段有索引，结果应该等于PAYLOAD
        Assert.assertTrue(jdbcTemplate.queryForObject("SELECT data FROM `r` WHERE name=?", new Object[]{("item" + (ThreadLocalRandom.current().nextInt(CommonMistakesApplication.ROWS) + 1))}, String.class)
                .equals(CommonMistakesApplication.PAYLOAD));
    }


}
