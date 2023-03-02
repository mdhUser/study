package org.maxwell.wrongcase.actuator_24.web;

import lombok.extern.slf4j.Slf4j;
import org.maxwell.wrongcase.actuator_24.utils.ThreadPoolProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/1 10:40
 */
@Slf4j
@RestController
public class TaskController {


    @GetMapping("slowTask")
    public void slowTask() {
        ThreadPoolProvider.getDemoThreadPool().execute(() -> {
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
            }
        });
    }




}
