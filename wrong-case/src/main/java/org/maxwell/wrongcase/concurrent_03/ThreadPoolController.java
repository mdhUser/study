package org.maxwell.wrongcase.concurrent_03;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/5 21:25
 */
@Slf4j
@Controller
@RequestMapping("/threadPool")
public class ThreadPoolController {


    private void printStats(ThreadPoolExecutor threadPool) {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            log.info("=========================");
            log.info("Pool Size: {}", threadPool.getPoolSize());
            log.info("Active Threads: {}", threadPool.getActiveCount());
            log.info("Number of Tasks Completed: {}", threadPool.getCompletedTaskCount());
            log.info("Number of Tasks in Queue: {}", threadPool.getQueue().size());
            log.info("=========================");
        }, 0, 1, TimeUnit.SECONDS);
    }

    @GetMapping("/right")
    public int right() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("demo-threadPool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());
        //threadPool.prestartAllCoreThreads();
        //threadPool.allowCoreThreadTimeOut(true);

        printStats(threadPool);

        IntStream.rangeClosed(1, 20).forEach(__ -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int id = counter.incrementAndGet();
            try {
                threadPool.submit(() -> {
                    log.info("{} started", id);
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception e) {
                log.error("error submitting task {}", id, e);
                counter.decrementAndGet();
            }
        });
        TimeUnit.SECONDS.sleep(60);
        return counter.intValue();
    }


}
