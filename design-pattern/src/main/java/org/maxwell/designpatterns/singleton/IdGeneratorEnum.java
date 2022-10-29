package org.maxwell.designpatterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/10/28 23:03
 */
public enum IdGeneratorEnum {


    INSTANCE;
    private final AtomicInteger id = new AtomicInteger(0);

    public Integer getId() {
        return id.incrementAndGet();
    }

}
