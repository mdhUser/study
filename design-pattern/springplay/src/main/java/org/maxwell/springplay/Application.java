package org.maxwell.springplay;

import org.maxwell.springplay.observer.SendMsgObserver;
import org.maxwell.springplay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationListener;

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

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(userService.out("FU"));
        //sendMsgObserver.notify("bizType1", "业务1的内容");
        //sendMsgObserver.notify("bizType2", "业务2的内容");
    }
}
