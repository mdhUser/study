package org.maxwell.wrongcase.clientdata_27.clientIp;

import org.maxwell.properties.HelloProperties;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.io.IOException;

@EnableFeignClients
//@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
@Import(HelloProperties.class)
public class ClientDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientDataApplication.class, args);
    }


    @Bean
    public RedissonClient redissonClient() throws IOException {
        Config config = Config.fromYAML(this.getClass().getClassLoader().getResourceAsStream("redisson-config.yml"));
        return Redisson.create(config);
    }


}
