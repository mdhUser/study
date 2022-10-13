package org.maxwell.se.base.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程测试
 */
public class TicketLockDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(ticket, "黄牛1").start();
        new Thread(ticket, "黄牛2").start();
        new Thread(ticket, "黄牛3").start();

    }
}


class TicketLock implements Runnable {

    private int count = 100;
    private final Lock LOCK = new ReentrantLock();

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        while (true) {
             LOCK.lock();
            try {
                if (count > 0) {
                    count--;
                    System.out.println(name + "收票！余票：" + count);
                } else {
                    System.out.println("票已抢完！");
                    break;
                }
            } finally {
                LOCK.unlock();
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}