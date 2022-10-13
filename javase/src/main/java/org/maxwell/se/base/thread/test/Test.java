package org.maxwell.se.base.thread.test;


import org.maxwell.se.base.entity.Hero;

/**
 * @description: test
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/14 14:07
 */
public class Test {

    public static void main(String[] args) {

        final Hero hero = new Hero();
        hero.setName("陈冠希");
        hero.setHp(666);

        Thread hurt = new Thread() {
            @Override
            public void run() {
                while (true) {
                    hero.hurt();
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