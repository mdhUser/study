package org.maxwell.juc.demo;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/4/25 16:49
 */
public class HappensBeforeFinalDemo {

    final int x;


    public HappensBeforeFinalDemo() {
        this.x = 3;

    }
}
