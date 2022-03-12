package com.maxwell.base.thread.test;


import com.maxwell.base.thread.ThreadPool;

/**
 * @description: 测试线程池
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/14 15:17
 */
public class TestThreadPool {


    public static void main(String[] args) {

        ThreadPool tp = new ThreadPool(10);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Thread task = new Thread() {
                @Override
                public void run() {
                    System.out.println("执行任务!");
                }
            };
            tp.add(task);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}