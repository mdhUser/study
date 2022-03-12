package com.maxwell.base.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: java自带线程池使用
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/14 15:53
 */
public class ThreadPoolJava {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        threadPool.execute(new Runnable(){

            @Override
            public void run() {

                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                            System.out.println("执行任务!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }

        });


    }

}
