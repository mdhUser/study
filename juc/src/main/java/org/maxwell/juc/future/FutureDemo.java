package org.maxwell.juc.future;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/1 11:20
 */
@Slf4j
public class FutureDemo {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            2, 3,
            10000,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new ThreadFactoryBuilder().setNameFormat("tl-%d")
                    //设置异常捕捉
                    .setUncaughtExceptionHandler((t, e) -> log.error("ThreadPool {} got exception", t, e))
                    .build(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );


    /**
     * 使用独立线程
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testFutureTask() throws ExecutionException, InterruptedException {

        FutureTask<String> f2 = new FutureTask<String>(new Worker2());

        FutureTask<String> f1 = new FutureTask<>(new Worker1(f2));

        new Thread(f2).start();
        new Thread(f1).start();

        String s = f1.get();
        log.info(s);
    }

    /**
     * 使用线程池实现烧开水
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void testTpl() throws ExecutionException, InterruptedException {
        FutureTask<String> f2 = new FutureTask<>(new Worker2());
        FutureTask<String> f1 = new FutureTask<>(new Worker1(f2));

        //此时如果线程只有一个就会导致永久阻塞等待t2完成
        threadPoolExecutor.execute(f1);
        threadPoolExecutor.execute(f2);

        String s = f1.get();
        log.info(s);
        //关闭线程池
        threadPoolExecutor.shutdown();

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testFutureTask();
        testTpl();
    }

    static class Worker1 implements Callable<String> {

        FutureTask<String> ft2;

        public Worker1(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            log.info("T1:洗水壶。。。");
            TimeUnit.SECONDS.sleep(1);
            log.info("T1:烧开水。。。");
            TimeUnit.SECONDS.sleep(15);
            //阻塞获取ft2的茶叶
            String tea = ft2.get();
            log.info("T1:拿到茶叶：{}", tea);
            log.info("T1:泡茶。。。");
            return "上茶：" + tea;
        }
    }


    static class Worker2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            log.info("T2:洗茶壶...");
            TimeUnit.SECONDS.sleep(1);
            log.info("T2:洗茶杯...");
            TimeUnit.SECONDS.sleep(2);
            log.info("T2:拿茶叶...");
            TimeUnit.SECONDS.sleep(1);
            return "龙井";
        }
    }


}
