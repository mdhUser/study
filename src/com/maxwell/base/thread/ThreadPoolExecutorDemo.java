package com.maxwell.base.thread;

import java.util.concurrent.*;

/**
 * @description: 线程池执行器
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 21:29
 */
public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadpool = Executors.newFixedThreadPool(3);
        Future<Integer> future = threadpool.submit(new Add(100));
        threadpool.shutdown();
        System.out.println(future.get());

    }

}

class Add implements Callable<Integer> {

    private int a;

    public Add(int a) {
        this.a = a;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= a; i++) {
            sum += i;
        }
        return sum;
    }
}