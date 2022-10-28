package org.maxwell.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description: 支持高并发的懒加载单例
 * @email: maodihui@foxmail.com
 * @date: 2022/10/28 17:12
 */
public class IdGeneratorLazy {


    private static final AtomicInteger id = new AtomicInteger(0);

    private IdGeneratorLazy() {
    }

    private static final class InstanceHolder {
        private static final IdGeneratorLazy instance = new IdGeneratorLazy();
    }

    public static IdGeneratorLazy getInstance() {
        return InstanceHolder.instance;
    }

    public static Integer getId() {
        return id.incrementAndGet();
    }

}
