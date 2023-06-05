package org.maxwell.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/4 20:41
 */
public class ForkJoinDemo {

    public static void main(String[] args) {
        testForkJoin();
        //testNormal();
    }


    private static void testNormal() {
        long begin = System.currentTimeMillis();
        int result = fibonacci(30);
        System.out.println(result + "--- 耗时：%d ms".formatted(System.currentTimeMillis() - begin));
    }

    private static void testForkJoin() {
        //创建分治任务线程池
        ForkJoinPool fjp =
                new ForkJoinPool(4);
        //创建分治任务
        Fibonacci fib =
                new Fibonacci(30);
        //启动分治任务
        long begin = System.currentTimeMillis();
        Integer result =
                fjp.invoke(fib);
        //输出结果
        System.out.println(result + "--- 耗时：%d ms".formatted(System.currentTimeMillis() - begin));
    }


    //递归任务
    static class Fibonacci extends
            RecursiveTask<Integer> {
        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        protected Integer compute() {
            if (n <= 1)
                return n;
            Fibonacci f1 =
                    new Fibonacci(n - 1);
            //创建子任务
            f1.fork();
            Fibonacci f2 =
                    new Fibonacci(n - 2);
            //等待子任务结果，并合并结果
            return f2.compute() + f1.join();
        }
    }


    /**
     * 普通递归方法实现斐波那契数列
     *
     * @return
     */
    static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
