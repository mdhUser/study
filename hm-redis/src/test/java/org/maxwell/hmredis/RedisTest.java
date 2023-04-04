package org.maxwell.hmredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.maxwell.hmredis.pojo.User;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/20 21:59
 */
@Slf4j
@SpringBootTest
public class RedisTest {

    //@Autowired
    //private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedissonClient redissonClient;


    //@Test
    //void testString() {
    //    redisTemplate.opsForValue().set("name", "Maxwell");
    //}
    //
    //@Test
    //void testObj() {
    //    redisTemplate.opsForValue().set("user:mao", new User("dakhj", 123));
    //    User o = (User) redisTemplate.opsForValue().get("user:mao");
    //    System.out.println(o);
    //}


    @Test
    void testStrTemplate() throws JsonProcessingException {

        User jackson = new User("Jackson", 45);
        String string = objectMapper.writeValueAsString(jackson);

        stringRedisTemplate.opsForValue().set("user:jackson", string);
        String get = stringRedisTemplate.opsForValue().get("user:jackson");

        User user = objectMapper.readValue(get, User.class);
        System.out.println(user);

    }

    ExecutorService thp = Executors.newFixedThreadPool(10);

    @Test
    void testStrTemplate1() {

        //Map<Object, Object> s = stringRedisTemplate.opsForHash().entries("s");
        //stringRedisTemplate.opsForValue().multiGet()

    }

    private AtomicInteger integer = new AtomicInteger();

    /**
     * 测试Redisson
     *
     * @throws InterruptedException
     */
    @Test
    void testStrTemplate2() throws InterruptedException {

        //Map<Object, Object> s = stringRedisTemplate.opsForHash().entries("s");
        //stringRedisTemplate.opsForValue().multiGet()
        RLock lock = redissonClient.getLock("lock");
        for (int i = 0; i < 10; i++) {
            thp.submit(() -> {
                try {
                    if (lock.tryLock(10, 5, TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + "  拿到锁");
                        for (int j = 0; j < 100; j++) {
                            integer.incrementAndGet();
                        }
                        System.out.println(Thread.currentThread().getName() + " 计算结果 a=" + integer.get());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    System.out.println(Thread.currentThread().getName() + "  释放锁");
                    lock.unlock();
                }
            });
        }
        thp.awaitTermination(1, TimeUnit.HOURS);
    }

    /**
     * 使用管道删除
     *
     * @throws InterruptedException
     */
    @Test
    void delAllKeys1() throws InterruptedException {

        Set<String> keys = stringRedisTemplate.keys("*");
        stringRedisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                keys.forEach(k -> connection.del(k.getBytes()));
                return null;
            }
        });

    }

    /**
     * 使用Redis lua 脚本删除
     *
     * @throws InterruptedException
     */
    @Test
    void delAllKeys2() throws InterruptedException {
        Set<String> keys = stringRedisTemplate.keys("*");
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        script.setScriptText("return redis.call('del',unpack(KEYS))");
        script.setResultType(Long.class);
        stringRedisTemplate.execute(script, new ArrayList<>(keys));
    }



    @Test
    void testReentrant() throws InterruptedException {
        RLock lock = redissonClient.getLock("lock");

        boolean isLock = lock.tryLock(1,TimeUnit.SECONDS);
        if (!isLock){
            log.info("获取锁失败，1");
        }
        try {
            log.info("获取锁成功，1");
            extracted(lock);
        } finally {
            log.info("释放锁，1");
            lock.unlock();
        }
    }

    private void extracted(RLock lock) {
        boolean isLock = lock.tryLock();
        if (!isLock){
            log.info("获取锁失败，2");
        }
        try {
            log.info("获取锁成功，2");

        } finally {
            log.info("释放锁，2");
            lock.unlock();
        }
    }


}
