package com.maxwell.base.thread.test;

/**
 * @description: 消费者
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 15:46
 */
public class Foodie implements Runnable {

    @Override
    public void run() {

        while (true) {

            synchronized (Desk.DISH) {
                if (Desk.DISH.size() == 0) {
                    System.out.println("没有汉堡了等待！。。。");
                    try {
                        Desk.DISH.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String remove = Desk.DISH.remove(0);
                System.out.println("已吃" + remove + "还剩" + Desk.DISH.size());

            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}