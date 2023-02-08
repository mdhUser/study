package org.maxwell.wrongcase.spring_19.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aop/test")
public class TestController {
    @GetMapping
    public void test() {

    }
}