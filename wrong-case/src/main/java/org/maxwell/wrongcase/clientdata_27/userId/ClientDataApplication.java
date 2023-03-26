package org.maxwell.wrongcase.clientdata_27.userId;

import org.maxwell.properties.HelloProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
@Import(HelloProperties.class)
public class ClientDataApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ClientDataApplication.class, args);
    }


    @Bean
    public RedissonClient redissonClient() throws IOException {
        Config config = Config.fromYAML(this.getClass().getClassLoader().getResourceAsStream("redisson-config.yml"));
        return Redisson.create(config);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginRequiredArgumentResolver());
    }
}
