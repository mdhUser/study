package org.maxwell.juc.threadpooldemo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/29 16:09
 */
@Slf4j
public class ThreadPoolDemo {


    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, 3,
            10000,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            new ThreadFactoryBuilder().setNameFormat("tl-%d")
                    //设置异常捕捉
                    .setUncaughtExceptionHandler((t, e) -> log.error("ThreadPool {} got exception", t, e))
                    .build(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    static void testExec() {
        //threadPoolExecutor.allowCoreThreadTimeOut(true);
        //execute异常抛出线程退出 创建新线程
        IntStream.rangeClosed(1, 10).forEach(i -> threadPoolExecutor.execute(() -> {
            if (i == 5) {
                throw new RuntimeException("error ");
            }
            log.info("I'm done : {}", i);
        }));
    }

    static void testSubmit() {
        //execute异常抛出线程退出 创建新线程
        List<? extends Future<?>> error = IntStream.rangeClosed(1, 10).mapToObj(i -> threadPoolExecutor.submit(() -> {
            if (i == 5) {
                throw new RuntimeException("error");
            }
            log.info("I'm done : {}", i);
        })).toList();

        error.forEach(e->{
            try {
                e.get();
            } catch (Exception ex) {
                log.error("got exception", ex);
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {
        testExec();
//        testSubmit();
//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.awaitTermination(10,TimeUnit.SECONDS);
        threadPoolExecutor.submit(()-> System.out.println("hello this is maxwell !"));

    }

}
