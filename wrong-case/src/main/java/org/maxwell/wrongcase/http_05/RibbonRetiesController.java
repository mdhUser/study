package org.maxwell.wrongcase.http_05;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.http_05.rpc.SmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 11:28
 */
@Slf4j
@RestController
public class RibbonRetiesController {


    @Autowired
    private SmsClient client;


    @GetMapping("/sms/wrong")
    public String wrong() {
        log.info("client is called");
        try {
            // 通过Feign调用发送短信接口
            client.sendSmsWrong("13600000000", UUID.randomUUID().toString());
        } catch (Exception ex) {
            //捕获可能出现的网络错误
            log.error("send sms failed : {}", ex.getMessage());
        }
        return "done";
    }

}
