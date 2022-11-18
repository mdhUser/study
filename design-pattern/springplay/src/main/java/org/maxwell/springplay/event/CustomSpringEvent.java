package org.maxwell.springplay.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 15:06
 */
public class CustomSpringEvent extends ApplicationEvent {
    private final String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
