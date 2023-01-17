package org.maxwell.wrongcase.connection_04;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/13 11:44
 */
@Slf4j
@RestController
public class ConnectionController {

    @Autowired
    private JedisPool jedisPool;


    @GetMapping("/testJedis")
    public void testJedis() throws InterruptedException {
        //使用连接池规避多线程安全问题
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                for (int i = 0; i < 1000; i++) {
                    String a = jedis.get("a");
                    if (!"1".equals(a)) {
                        log.warn("Expect a to be 1 but found {}", a);
                        return;
                    }
                }
            }
        }).start();
        new Thread(() -> {
            try (Jedis jedis = jedisPool.getResource()) {
                for (int i = 0; i < 1000; i++) {
                    String b = jedis.get("b");
                    if (!"2".equals(b)) {
                        log.warn("Expect b to be 2 but found {}", b);
                        return;
                    }
                }
            }
        }).start();
        log.info("~~~ over request ~~~~");
        TimeUnit.SECONDS.sleep(5);
    }

}
