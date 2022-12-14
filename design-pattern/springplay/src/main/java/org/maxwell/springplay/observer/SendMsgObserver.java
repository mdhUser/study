package org.maxwell.springplay.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 观察者类
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/12/14 22:13
 */
@Component
public class SendMsgObserver implements Observer {

    @Autowired
    private List<SendMsgService> sendMsgServices;

    @Override
    public void notify(String bizType, String content) {
        List<String> strategy = ConfigCenter.getStrategy(bizType);
        sendMsgServices.forEach(sendMsgService -> {
            if (strategy.contains(sendMsgService.getClass().getDeclaredAnnotation(Service.class).value())) {
                sendMsgService.sendMsg(content);
            }
        });


    }
}