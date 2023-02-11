package org.maxwell.wrongcase.spring_20;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.StandardEnvironment;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/9 15:50
 */
@Slf4j
@EnableFeignClients(basePackages = "org.maxwell.wrongcase.spring_20.feign")
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @Autowired
    private StandardEnvironment env;

    @PostConstruct
    public void init() {
        Arrays.asList("user.name", "management.server.port").forEach(key -> {
            env.getPropertySources().forEach(propertySource -> {
                if (propertySource.containsProperty(key)) {
                    log.info("{} -> {} 实际取值：{}", propertySource, propertySource.getProperty(key), env.getProperty(key));
                }
            });
        });

        System.out.println("配置优先级：");
        env.getPropertySources().stream().forEach(System.out::println);
    }


}
