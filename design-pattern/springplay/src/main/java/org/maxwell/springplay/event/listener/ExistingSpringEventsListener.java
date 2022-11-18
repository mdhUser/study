package org.maxwell.springplay.event.listener;

import org.maxwell.springplay.event.GenericSpringEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 16:41
 */
@Component
public class ExistingSpringEventsListener {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Handling context re-freshed event-" + event.getSource());
    }

    @EventListener
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Handling context start event-" + event.getSource());
    }

    @EventListener
    public void onApplicationEvent(RequestHandledEvent event) {
        System.out.println("Handling context request event-" + event.getSource());
    }

    @EventListener
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("Handling context closed event-" + event.getSource());
    }

    
    @EventListener(condition = "#event.isSuccess()")
    public void onApplicationEvent(GenericSpringEvent<String> event) {
        System.out.println("~~ into GenericSpringEventListener ~~");
        System.out.println("Handling generic is event: " + event.getWhat());
    }
}