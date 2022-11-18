package org.maxwell.springplay.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

/**
 * @author Maxwell
 * @description: 设置监听器异步处理
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 16:31
 */
@Configuration
public class AsynchronousSpringEventConfig {

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(Executors.newFixedThreadPool(4));
        return eventMulticaster;
    }

}
