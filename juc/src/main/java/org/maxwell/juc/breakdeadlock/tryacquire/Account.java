package org.maxwell.juc.breakdeadlock.tryacquire;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/7 17:21
 */
public class Account {

    private int balance;

    private final Lock lock = new ReentrantLock();


    void transfer(Account tar, int amt) throws InterruptedException {
        while (true) {
            if (lock.tryLock()) {
                try {
                    try {
                        if (tar.lock.tryLock()) {
                            this.balance -= amt;
                            tar.balance += amt;
                            break;
                        }
                    } finally {
                        tar.lock.unlock();
                    }
                } finally {
                    lock.unlock();
                }
            }
            //添加随机数避免活锁
            TimeUnit.MILLISECONDS.sleep(randomNum());
        }
    }


    int randomNum() {
        return ThreadLocalRandom.current().nextInt(10);
    }


}