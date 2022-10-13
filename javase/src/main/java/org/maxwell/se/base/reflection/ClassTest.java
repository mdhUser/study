package org.maxwell.se.base.reflection;

/**
 * @description: java反射理解
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 10:51
 */
public class ClassTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                method1();
            }
        };
        thread1.setName("线程1");
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                method2();
            }
        };
        thread2.setName("线程2");
        thread2.start();

    }

    /**
     * 静态方法的synchronized同步对象是当前类对象
     *
     */

    public static void method1() {
        synchronized (ClassTest.class) {
            System.out.println(Thread.currentThread().getName() + " 进入了method1方法");
            try {
                System.out.println("运行5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void method2() {
        System.out.println(Thread.currentThread().getName() + " 进入了method2方法");
        try {
            System.out.println("运行5秒");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
