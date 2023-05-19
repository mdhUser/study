package org.maxwell.juc.demo;

import java.util.concurrent.Semaphore;

/**
 * 信号量模型实现互斥锁
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/18 22:32
 */
public class SemaphoreDemo {

    int count;

    /**
     * 可以设置多个线程同时访问临界区
     */
    Semaphore semaphore = new Semaphore(1);

    void addOne() throws InterruptedException {
        semaphore.acquire();
        try {
            count++;
        } finally {
            semaphore.release();
        }
    }


}
