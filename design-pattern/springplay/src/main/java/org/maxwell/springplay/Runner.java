package org.maxwell.springplay;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/17 21:05
 */
@Component
public class Runner implements CommandLineRunner, ApplicationRunner {
    @Override
    public void run(String... args) throws Exception {

        System.out.println("~~ spring CommandLineRunner");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("~~ spring ApplicationRunner");
    }


}
