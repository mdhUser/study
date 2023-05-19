package org.maxwell.juc.demo;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/4/25 16:28
 */
public class HappensBeforeStartDemo {

    static int a;

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            if (a == 77) {
                System.out.println(true);
            }
        });
        a = 77;
        thread.start();
    }

}
