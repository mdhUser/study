package org.maxwell.juc.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/5 16:52
 */
public class RateLimiterDemo {


    static long prev = System.nanoTime();

    public static void main(String[] args) throws InterruptedException {

        /**
         * 限流器流速：2个请求/秒
         */
        RateLimiter limiter = RateLimiter.create(2.0);

        ExecutorService es = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 20; i++) {
            limiter.acquire();
            es.execute(() -> {
                long cur = System.nanoTime();
                //打印时间间隔：毫秒
                System.out.println((cur - prev)
                        / 1000_000);
                prev = cur;
            });
        }

        es.awaitTermination(1,TimeUnit.MINUTES);

    }


}
