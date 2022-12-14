package org.maxwell.springplay.observer.impl;

import org.maxwell.springplay.observer.SendMsgService;
import org.springframework.stereotype.Service;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/12/14 22:33
 */
@Service("email")
public class EmailSendService implements SendMsgService {
    @Override
    public void sendMsg(String content) {
        System.out.println("邮件发送：" + content);
    }
}
