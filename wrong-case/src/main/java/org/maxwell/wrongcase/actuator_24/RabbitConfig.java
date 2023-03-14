package org.maxwell.wrongcase.actuator_24;

import org.maxwell.wrongcase.actuator_24.utils.Consts;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/10 14:23
 */
@Configuration
public class RabbitConfig {


    //队列
    @Bean
    public Queue queue() {
        return new Queue(Consts.QUEUE);
    }

    //交换器
    @Bean
    public Exchange exchange() {
        return ExchangeBuilder.directExchange(Consts.EXCHANGE).durable(true).build();
    }

    //绑定
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(Consts.ROUTING_KEY).noargs();
    }



}
