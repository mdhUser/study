package org.maxwell.wrongcase.http_05;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.http_05.rpc.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/17 14:17
 */
@Slf4j
@RestController
public class ClientReadTimeoutController {


    @Autowired
    private Client client;


    @GetMapping("client")
    public void timeout() {
        long begin = System.currentTimeMillis();
        try {
            client.server();
        } catch (Exception ex) {
            log.warn("执行耗时：{}ms 错误：{}", System.currentTimeMillis() - begin, ex.getMessage());
        }
    }


}
