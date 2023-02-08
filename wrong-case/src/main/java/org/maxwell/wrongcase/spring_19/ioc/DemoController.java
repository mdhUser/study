package org.maxwell.wrongcase.spring_19.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/7 16:56
 */
@Slf4j
@Controller
public class DemoController {

    @Autowired
    private List<SayService> sayServices;

    @Autowired
    private ApplicationContext context;

    @GetMapping("/ioc/test")
    public void test() {
        log.info("====================");
        sayServices.forEach(SayService::say);
    }


    @GetMapping("/ioc/test1")
    public void test1() {
        log.info("====================");
        context.getBeansOfType(SayService.class).values().forEach(SayService::say);
    }


}
