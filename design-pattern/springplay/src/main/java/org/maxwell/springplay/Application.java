package org.maxwell.springplay;

import org.maxwell.springplay.factory.Client;
import org.maxwell.springplay.factory.ContentType;
import org.maxwell.springplay.observer.SendMsgObserver;
import org.maxwell.springplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;

import java.util.List;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
//        springApplication.addListeners(new SpringApplicationRunListener());
        springApplication.run(args);
    }

    @Autowired
    private UserService userService;

    @Autowired
    private SendMsgObserver sendMsgObserver;

    @Autowired
    private Client client;

    @Override
    public void run(String... args) throws Exception {
        List all = client.getAll(ContentType.JSON);
    }
}
