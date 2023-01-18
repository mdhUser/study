package org.maxwell.wrongcase.http_05.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/17 16:49
 */
@FeignClient(name = "sms", url = "http://127.0.0.1:8080")
public interface SmsClient {

    @GetMapping("/ribbonretryissueserver/sms")
    void sendSmsWrong(@RequestParam("mobile") String mobile, @RequestParam("message") String message);

}
