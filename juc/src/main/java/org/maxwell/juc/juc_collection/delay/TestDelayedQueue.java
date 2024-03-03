package org.maxwell.juc.juc_collection.delay;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.DelayQueue;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/2 14:32
 */
@Slf4j
public class TestDelayedQueue {

    public static void main(String[] args) throws InterruptedException {

        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();

        delayQueue.add(new DelayedTask(1000, () -> log.info("task 1")));
        delayQueue.add(new DelayedTask(2000, () -> log.info("task 2")));
        delayQueue.add(new DelayedTask(3000, () -> log.info("task 3")));

        while (!delayQueue.isEmpty()) {
            //阻塞获取到先到期的任务
            DelayedTask task = delayQueue.take();
            task.execute();
        }

    }

}
