package com.maxwell.base.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description: callable启动
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 17:50
 */
public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask1 = new FutureTask(() -> {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            return Thread.currentThread().getName()+":"+sum;
        });

        FutureTask<String> futureTask2 = new FutureTask(() -> {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
            return Thread.currentThread().getName()+":"+sum;
        });

        new Thread(futureTask1,"线程1").start();
        new Thread(futureTask2,"线程2").start();

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());




    }

}