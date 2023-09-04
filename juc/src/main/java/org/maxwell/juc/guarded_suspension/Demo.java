package org.maxwell.juc.guarded_suspension;

import java.util.Objects;

/**
 *
 *  Guarded Suspension 模式
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/25 15:33
 */
public class Demo {


    //处理浏览器发来的请求
    String handleWebReq() {
        //创建一消息
        Message msg1 = new
                Message("1", "{...}");
        //发送消息
        send(msg1);
        //利用GuardedObject实现等待
        GuardedObject<Message> go = GuardedObject.create("1");
        Message message = go.get(Objects::nonNull);
        return message.content;
    }

    void onMessage(Message msg) {
        //唤醒等待线程
        GuardedObject.fireEvent("1", msg);
    }

    //该方法可以发送消息
    void send(Message msg) {
        //省略相关代码
    }


}
