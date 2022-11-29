package org.maxwell.springplay.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.*;

/**
 * @author Maxwell
 * @description: 设置监听器异步处理
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 16:31
 */
@Configuration
public class AsynchronousSpringEventConfig {
    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(100)
    );

    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(executor);
        return eventMulticaster;
    }

}
