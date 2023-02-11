package org.maxwell.wrongcase.spring_20;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.spring_20.feign.Client;
import org.maxwell.wrongcase.spring_20.feign.ClientWithUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("feignaop")
public class FeignAopController {

    @Autowired
    private Client client;

    @Autowired
    private ClientWithUrl clientWithUrl;

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("client")
    public String client() {
        return client.api();
    }

    //固定URL之后无法被切面切到
    @GetMapping("clientWithUrl")
    public String clientWithUrl() {
        return clientWithUrl.api();
    }

    @GetMapping("server")
    public String server() {
        return "OK";
    }
}
