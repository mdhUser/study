package org.maxwell.juc.completablefuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/2 09:50
 */
@Slf4j
public class AsyncTeaDemo {


    void test() {
        //任务1
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            log.info("T1:洗水壶...");
            sleep(1, TimeUnit.SECONDS);
            log.info("T1:烧开水...");
            sleep(15, TimeUnit.SECONDS);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            log.info("T2:洗茶壶...");
            sleep(1, TimeUnit.SECONDS);
            log.info("T2:洗茶杯...");
            sleep(2, TimeUnit.SECONDS);
            log.info("T2:拿茶叶...");
            sleep(1, TimeUnit.SECONDS);
            return "龙井";
        });

        //f2
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            log.info("T1:拿到茶叶:{}", tf);
            log.info("T1:泡茶...");
            return "上茶：" + tf;
        });

        //同步阻塞获取结果
        String result = f3.join();
        System.out.println(result);

    }


    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }


    public static void main(String[] args) {
        AsyncTeaDemo teaDemo = new AsyncTeaDemo();
        teaDemo.test();
    }


}