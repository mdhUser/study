package org.maxwell.se.base.thread;

import org.maxwell.se.base.entity.Hero;

/**
 * @description: 线程交互
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/14 11:14
 */
public class ThreadInteractive {


    public static void main(String[] args) {

        final Hero hero = new Hero();
        hero.setName("盾山");
        hero.setHp(500);

        Thread hurt = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (hero.getHp() == 1)
                        continue;
                    hero.hurt();
                    System.out.printf("英雄%s受到1点伤害 血量：%f%n", hero.getName(), hero.getHp());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        hurt.start();

        Thread recover = new Thread() {
            @Override
            public void run() {
                while (true) {
                    hero.recover();
                    System.out.printf("英雄%s回复血量：%f%n", hero.getName(), hero.getHp());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        recover.start();
    }
}