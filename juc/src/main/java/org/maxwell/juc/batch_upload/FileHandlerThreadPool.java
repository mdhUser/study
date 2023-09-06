package org.maxwell.juc.batch_upload;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 *  文件处理线程池
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/6 23:00
 */
@Slf4j
@Configuration
public class FileHandlerThreadPool {


    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor fileHandlerThreadPool(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadFactory(
                new ThreadFactoryBuilder()
                        //设置异常捕捉
                        .setUncaughtExceptionHandler((t, e) ->
                                log.error("ThreadPool {} got exception", t, e)
                        ).build()
                );
        threadPoolTaskExecutor.setCorePoolSize(100);
        threadPoolTaskExecutor.setMaxPoolSize(1000);
        threadPoolTaskExecutor.setKeepAliveSeconds(120);
        threadPoolTaskExecutor.setQueueCapacity(10000);
        threadPoolTaskExecutor.setThreadNamePrefix("file-task-%d");
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskExecutor;

    }


}
