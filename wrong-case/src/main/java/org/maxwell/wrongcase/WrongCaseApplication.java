package org.maxwell.wrongcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
public class WrongCaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(WrongCaseApplication.class, args);
    }
}
