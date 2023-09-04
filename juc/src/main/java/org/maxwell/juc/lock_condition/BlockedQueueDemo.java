package org.maxwell.juc.lock_condition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/9 17:10
 */
public class BlockedQueueDemo<T> {

    private final Lock lock = new ReentrantLock();

    Condition notFull = lock.newCondition();

    Condition notEmpty = lock.newCondition();

    List<T> queue = new ArrayList<>(100);

    public void enq(T t) throws InterruptedException {
        lock.lock();
        try {
            //队列已满
            while (queue.size() == 100) {
                //等待不满
                notFull.await();
            }
            queue.add(t);
            //入队后通知队列未空可出队
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public void deq() throws InterruptedException {
        lock.lock();
        try {
            //队列已满
            while (queue.size() == 0) {
                //等待不满
                notEmpty.await();
            }
            queue.remove(0);
            //出队后通知队列未满可入队
            notFull.signal();
        } finally {
            lock.unlock();
        }

    }


}
