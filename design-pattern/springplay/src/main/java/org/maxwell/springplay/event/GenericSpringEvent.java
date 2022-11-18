package org.maxwell.springplay.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 16:58
 */
public class GenericSpringEvent<T> extends ApplicationEvent {

    private final T what;

    private final boolean success;

    public GenericSpringEvent(Object source,T what, boolean success) {
        super(source);
        this.what = what;
        this.success = success;
    }

    public T getWhat() {
        return what;
    }

    public boolean isSuccess() {
        return success;
    }
}
