package org.maxwell.wrongcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
public class WrongCaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WrongCaseApplication.class, args);
    }
}
