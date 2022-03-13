package com.maxwell.base.thread.test;

/**
 * @description: 生产者
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 15:37
 */
public class Cooker implements Runnable {

    int num;

    @Override
    public void run() {

        while (true) {

            synchronized (Desk.DISH) {
                if (Desk.DISH.size() >= 10) {
                    //盘子放不下，等待
                    try {
                        Desk.DISH.wait(1000);//todo 等待让顾客去吃
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //做汉堡
                num++;
                String hamburger ="汉堡:"+num;
                Desk.DISH.add(hamburger);
                System.out.println("已做汉堡"+Desk.DISH.size());

                Desk.DISH.notify();
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}