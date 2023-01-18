package org.maxwell.springplay.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/17 16:48
 */
@RestController
@Slf4j
public class RibbonRetryIssueServerController {
    @GetMapping("/ribbonretryissueserver/sms")
    public void sendSmsWrong(@RequestParam("mobile") String mobile,
                             @RequestParam("message") String message, HttpServletRequest request) throws InterruptedException {
        //输出调用参数后休眠2秒
        log.info("{} is called, {}=>{}", request.getRequestURL().toString(), mobile, message);
        TimeUnit.SECONDS.sleep(2);
    }

    /**
     * 模拟处理十分钟的业务接口
     */
    @PostMapping("/test/server")
    public void server01() throws InterruptedException {
        log.info("~~~ into controller ~~~");
        TimeUnit.MINUTES.sleep(10);
    }


    @GetMapping("/routelimit/server")
    public int server02() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        return 1;
    }


}