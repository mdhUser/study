package org.maxwell.wrongcase.jdk8new_31;

import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/4/13 16:08
 */
public class TestForeach {


    //模拟消息数据需要1秒时间
    private static void consume(int i) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(i);
    }

    //模拟过滤数据需要1秒时间
    private static boolean filter(int i) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i % 2 == 0;
    }

    public static void main(String[] args) {
        new TestForeach().test();
    }

    public void test() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", String.valueOf(10));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("stream");
        stream();
        stopWatch.stop();
        stopWatch.start("parallelStream");
        parallelStream();
        stopWatch.stop();
        stopWatch.start("parallelStreamForEachOrdered");
        parallelStreamForEachOrdered();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    //filtre和forEach串行
    private void stream() {
        IntStream.rangeClosed(1, 10)
                .filter(TestForeach::filter)
                .forEach(TestForeach::consume);
    }

    //filter和forEach并行
    private void parallelStream() {
        IntStream.rangeClosed(1, 10).parallel()
                .filter(TestForeach::filter)
                .forEach(TestForeach::consume);
    }

    //filter并行而forEach串行
    private void parallelStreamForEachOrdered() {
        IntStream.rangeClosed(1, 10).parallel()
                .filter(TestForeach::filter)
                .forEachOrdered(TestForeach::consume);
    }


}
