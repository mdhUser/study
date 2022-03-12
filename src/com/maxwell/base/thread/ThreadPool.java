package com.maxwell.base.thread;

import java.util.LinkedList;

/**
 * @description: 线程池
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/14 14:41
 */
public class ThreadPool {

    int poolSize;
    LinkedList<Runnable> tasks = new LinkedList<>();

    public ThreadPool(int size) {
        this.poolSize = size;
        synchronized (tasks) {
            for (int i = 0; i < size; i++) {
                new TaskThread("任务线程：" + i).start();
            }
        }

    }

    public void add(Runnable run) {
        synchronized (tasks) {
            tasks.add(run);
            //通知所有线程
            tasks.notifyAll();
        }
    }

    class TaskThread extends Thread {
        public TaskThread(String name) {
            super(name);
        }

        Runnable task;

        @Override
        public void run() {
            System.out.println("任务线程：" + this.getName() + "启动!");
            while (true) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task= tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + " 获取到任务，并执行");
                task.run();
            }
        }
    }
}
