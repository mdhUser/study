package org.maxwell.wrongcase.async_25.deadletter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RequestMapping("deadletter")
@RestController
public class DeadLetterController {

    AtomicLong atomicLong = new AtomicLong();
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("sendMessage")
    public void sendMessage() {
        String msg = "msg" + atomicLong.incrementAndGet();
        log.info("send message {}", msg);
        rabbitTemplate.convertAndSend(Consts.EXCHANGE, msg);
    }
}
