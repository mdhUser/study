package org.maxwell.aop;

import org.maxwell.aop.service.OrderService;
import org.maxwell.aop.service.SaveOrder;
import org.maxwell.aop.service.UpdateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {

        orderService.saveOrder(new SaveOrder(2L));

        orderService.updateOrder(new UpdateOrder(1L));

    }


}
