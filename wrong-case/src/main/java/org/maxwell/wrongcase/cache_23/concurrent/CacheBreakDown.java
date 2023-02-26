package org.maxwell.wrongcase.cache_23.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.maxwell.wrongcase.cache_23.RedisConstant.HOTSPOT;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/21 13:47
 */
@Slf4j
@RestController
@RequestMapping("cacheconurrent")
public class CacheBreakDown {


    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @PostConstruct
    public void init() {
        //初始化一个热点数据到Redis中，过期时间设置为5秒
        stringRedisTemplate.opsForValue().set(HOTSPOT, getExpensiveData(), 5, TimeUnit.SECONDS);
        //每隔1秒输出一下回源的QPS
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("DB QPS : {}", atomicInteger.getAndSet(0));
        }, 0, 1, TimeUnit.SECONDS);
    }

    private String getExpensiveData() {
        atomicInteger.incrementAndGet();
        return "important data";
    }

    @GetMapping("wrong")
    public String wrong() {
        String data = stringRedisTemplate.opsForValue().get(HOTSPOT);
        if (StringUtils.isEmpty(data)) {
            data = getExpensiveData();
            //重新加入缓存，过期时间还是5秒
            stringRedisTemplate.opsForValue().set(HOTSPOT, data, 5, TimeUnit.SECONDS);
        }
        return data;
    }


    @GetMapping("right")
    public String right() {
        String data = stringRedisTemplate.opsForValue().get(HOTSPOT);
        if (StringUtils.isBlank(data)) {
            RLock locker = redissonClient.getLock("locker");
            //获取分布式锁
            if (locker.tryLock()) {
                try {
                    data = stringRedisTemplate.opsForValue().get(HOTSPOT);
                    if (StringUtils.isBlank(data)) {
                        data = getExpensiveData();
                        stringRedisTemplate.opsForValue().set(HOTSPOT, data, 5, TimeUnit.SECONDS);
                    }
                } finally {
                    //释放锁
                    locker.unlock();
                }
            }
        }
        return data;
    }

}
