package org.maxwell.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description: 饿汉模式单例
 * @email: maodihui@foxmail.com
 * @date: 2022/10/28 16:36
 */
public class IdGenerator {

    private static final AtomicInteger id = new AtomicInteger(0);

    private static final IdGenerator instance = new IdGenerator();

    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }

    public static Integer getId() {
        return id.incrementAndGet();
    }

}
