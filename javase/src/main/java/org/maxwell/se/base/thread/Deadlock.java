package org.maxwell.se.base.thread;

/**
 * @description: 死锁演示
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 21:19
 */
public class Deadlock {

    public static void main(String[] args) {

        var lock1 = new Object();
        var lock2 = new Object();

        new Thread(() -> {
            while (true) {
                synchronized (lock1) {
                    System.out.println("获取锁1");
                    synchronized (lock2) {
                        System.out.println("获取锁2");
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (lock2) {
                    System.out.println("获取锁2");
                    synchronized (lock1) {
                        System.out.println("获取锁1");
                    }

                }
            }
        }).start();


    }


}