package org.maxwell.hmredis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/27 15:26
 */
@Slf4j
@SpringBootTest
public class RedissonMultiLockTest {

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private RedissonClient redissonClient1;

    @Autowired
    private RedissonClient redissonClient2;
    private RLock lock;
    @BeforeEach
    void setUp(){
        RLock lock1 = redissonClient.getLock("order");
        RLock lock2 = redissonClient1.getLock("order");
        RLock lock3 = redissonClient2.getLock("order");

        //创建联锁
        lock = redissonClient.getMultiLock(lock1, lock2, lock3);
    }


    @Test
    void testReentrant() throws InterruptedException {
        //在所有Redis节点中都设置锁order
        boolean isLock = lock.tryLock(1, TimeUnit.SECONDS);
        if (!isLock){
            log.info("获取锁失败，1");
        }
        try {
            log.info("获取锁成功，1");
            log.info("开始执行业务逻辑...");
            reentrant();
        } finally {
            log.info("释放锁，1");
            lock.unlock();
        }

    }

    private void reentrant() {
        boolean isLock = lock.tryLock();
        if (!isLock){
            log.info("获取锁失败，2");
        }
        try {
            log.info("获取锁成功，2");
            log.info("开始执行业务逻辑...");
        } finally {
            log.info("释放锁，2");
            lock.unlock();
        }
    }





}
