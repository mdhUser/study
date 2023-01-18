package org.maxwell.wrongcase.answer_07;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 16:44
 */
@Slf4j
@RestController
public class ThreadPoolDemoController {


    @GetMapping("/better")
    public int better() throws InterruptedException {
        ThreadPoolExecutor threadPool = RadicalThreadPool.get();
        //每秒打印线程状态
        Utils.printStats(threadPool);
        //任务编号计数器
        AtomicInteger atomicInteger = new AtomicInteger();
        IntStream.rangeClosed(1, 20).forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int id = atomicInteger.incrementAndGet();
            try {
                threadPool.submit(() -> {
                    log.info("{} started", id);
                    try {
                        TimeUnit.SECONDS.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    log.info("{} finished", id);
                });
            } catch (Exception ex) {
                log.error("error submitting task {}", id, ex);
                atomicInteger.decrementAndGet();
            }
        });
        TimeUnit.SECONDS.sleep(30);
        return atomicInteger.intValue();
    }

}