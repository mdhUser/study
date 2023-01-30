package org.maxwell.wrongcase.exception_12;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/30 09:44
 */
@Slf4j
@RestController
public class ThreadPoolExceptionDemoController {

    //static {
    //    Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> log.error("Thread {} got exception", thread, throwable));
    //}

    @GetMapping("/execute")
    public void execute() throws InterruptedException {

        String prefix = "test";
        ExecutorService threadPool = Executors.newFixedThreadPool(1,
                new ThreadFactoryBuilder()
                        .setNameFormat(prefix + "%d")
                        //设置线程池异常处理
                        .setUncaughtExceptionHandler((thread, error) -> log.error("ThreadPool {} got exception", thread, error))
                        .build());

        //execute异常抛出线程退出 创建新线程
        //IntStream.rangeClosed(1, 10).forEach(i -> threadPool.execute(() -> {
        //    if (i == 5) {
        //        throw new RuntimeException("error ");
        //    }
        //    log.info("I'm done : {}", i);
        //}));

        //submit 返回Future 不中断抛出
        List<Future> tasks = IntStream.rangeClosed(1, 10).mapToObj(i -> threadPool.submit(() -> {
            if (i == 5) {
                throw new RuntimeException("error ");
            }
            log.info("I'm done : {}", i);
        })).collect(Collectors.toList());

        tasks.forEach(task -> {
            try {
                task.get();
            } catch (Exception e) {
                log.error("got exception", e);
            }
        });

        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.HOURS);
    }

}
