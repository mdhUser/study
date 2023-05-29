package org.maxwell.juc.threadpooldemo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/29 15:54
 */
public class Main {



    public static void main(String[] args) {

        MyThreadPool threadPool = new MyThreadPool(10,new LinkedBlockingQueue<>(2));
        while (true) {
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            threadPool.execute(()-> System.out.println(Thread.currentThread().getName()+ " hello"));
        }

    }


}
