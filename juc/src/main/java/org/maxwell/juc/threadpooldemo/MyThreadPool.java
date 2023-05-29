package org.maxwell.juc.threadpooldemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

/**
 * 简易线程池
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/29 15:38
 */
public class MyThreadPool {

    BlockingQueue<Runnable> workQueue;

    List<WorkThread> threads = new ArrayList<>();


    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        //初始化阻塞队列
        this.workQueue = workQueue;
        //创建工作线程
        IntStream.rangeClosed(1, poolSize).forEach(__ -> {
            WorkThread workThread = new WorkThread();
            workThread.start();
            threads.add(workThread);
        });
    }

    /**
     * 提交任务
     * @param runnable
     */
    void execute(Runnable runnable) {
        try {
            workQueue.put(runnable);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task;
                try {
                    //获取阻塞队列中的任务
                    task = workQueue.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                task.run();
            }
        }
    }


}
