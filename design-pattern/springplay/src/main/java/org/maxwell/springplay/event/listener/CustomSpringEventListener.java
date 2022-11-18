package org.maxwell.springplay.event.listener;

import org.maxwell.springplay.event.CustomSpringEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 15:19
 */
@Component
public class CustomSpringEventListener {

    @EventListener
    public void onApplicationEvent(CustomSpringEvent event) {
        System.out.println("~~ Received spring custom event - ~~");
        String message = event.getMessage();
        System.out.println("~~ 处理消息：" + message);
    }
}
