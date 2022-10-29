package org.maxwell.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description: 支持高并发的懒加载单例
 * @email: maodihui@foxmail.com
 * @date: 2022/10/28 17:12
 */
public class IdGeneratorLazy {


    private final AtomicInteger id = new AtomicInteger(0);

    private static IdGeneratorLazy instance;

    private IdGeneratorLazy() {
    }

    //双端检查
    private static IdGeneratorLazy getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorLazy.class) {
                if (instance == null) {
                    instance = new IdGeneratorLazy();
                }
            }
        }
        return instance;
    }


    public Integer getId() {
        return id.incrementAndGet();
    }

}
