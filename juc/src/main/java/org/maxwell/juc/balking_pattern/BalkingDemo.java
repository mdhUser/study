package org.maxwell.juc.balking_pattern;

/**
 *
 *  多线程版本的if
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/4 16:00
 */
public class BalkingDemo {

    volatile boolean inited = false;
    int count;

    void init() {

        //保证互斥
        synchronized (this) {
            if (inited) {
                return;
            }
            inited = true;
        }

        count = calc();

    }

    /**
     * 计算
     *
     * @return
     */
    private int calc() {
        return 0;
    }


}
