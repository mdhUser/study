package org.maxwell.springplay.web;

import org.maxwell.springplay.event.publisher.CustomSpringEventPublisher;
import org.maxwell.springplay.event.publisher.GenericSpringEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 16:13
 */
@RestController
public class Web {

    @Autowired
    private GenericSpringEventPublisher genericPublisher;

    @Autowired
    private CustomSpringEventPublisher publisher;

    @GetMapping("/testEvent")
    public void test() {
        publisher.publishCustomEvent("test this spring event .");
    }


    @GetMapping("/testEvent1")
    public void test1(String message, byte success) {
        genericPublisher.sendMessage(message, success == 1);
    }



}
