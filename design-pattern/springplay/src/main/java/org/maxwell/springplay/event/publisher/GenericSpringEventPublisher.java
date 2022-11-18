package org.maxwell.springplay.event.publisher;

import org.maxwell.springplay.event.GenericSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 17:14
 */
@Component
public class GenericSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;


    public void sendMessage(String message, boolean success) {
        System.out.println("~~ Publishing custom event. ~~");
        GenericSpringEvent<String> event = new GenericSpringEvent<>(this,message, success);
        publisher.publishEvent(event);
    }

}
