package org.maxwell.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/10/28 17:19
 */
public class IdGeneratorStatic {


    private static final AtomicInteger id = new AtomicInteger(0);

    //使用静态内部类生产单例
    public static class IdGeneratorHolder {
        private static final IdGeneratorStatic instance = new IdGeneratorStatic();
    }

    public static IdGeneratorStatic getInstance() {
        return IdGeneratorHolder.instance;
    }

    public static Integer getId() {
        return id.incrementAndGet();
    }


}