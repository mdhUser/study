package org.maxwell.hmredis;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/23 16:43
 */
public class Demo {


    /**
     * K 表名
     * V 是否完成
     */
    public static final ConcurrentHashMap<String, Boolean> map = new ConcurrentHashMap<>();


    @Test
    public void testMap() throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Worker(i));
        }
        threadPool.awaitTermination(23,TimeUnit.SECONDS);
        map.forEach((k,v)-> System.out.println(k+"="+v));
    }

    class Worker implements Runnable {
        private final Integer taskId;

        public Worker(Integer taskId) {
            this.taskId = taskId;
        }
        @Override
        public void run() {
            System.out.println("this is task-" + taskId);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            map.putIfAbsent("task-"+taskId, Boolean.TRUE);
            System.out.printf("task-%d work over %n",taskId);
        }
    }


}
