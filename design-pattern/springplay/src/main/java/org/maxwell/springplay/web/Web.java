package org.maxwell.springplay.web;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.springplay.event.publisher.CustomSpringEventPublisher;
import org.maxwell.springplay.event.publisher.GenericSpringEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 16:13
 */
@Slf4j
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
    public void test1(@RequestParam(value = "message", required = false, defaultValue = "test") String message,
                      @RequestParam(value = "success", required = false, defaultValue = "1") byte success) {
        genericPublisher.sendMessage(message, success == 1);
    }

    /**
     * 模拟处理十分钟的业务接口
     */
    @PostMapping("/test/server")
    public void server() throws InterruptedException {
        log.info("~~~ into controller ~~~");
        TimeUnit.MINUTES.sleep(10);
    }

}
