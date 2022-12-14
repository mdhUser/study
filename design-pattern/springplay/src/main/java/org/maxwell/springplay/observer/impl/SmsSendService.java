package org.maxwell.springplay.observer.impl;

import org.maxwell.springplay.observer.SendMsgService;
import org.springframework.stereotype.Service;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/12/14 22:31
 */
@Service("sms")
public class SmsSendService implements SendMsgService {
    @Override
    public void sendMsg(String content) {
        System.out.println("短信发送：" + content);
    }
}
