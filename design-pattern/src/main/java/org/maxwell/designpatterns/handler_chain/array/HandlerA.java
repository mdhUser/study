package org.maxwell.designpatterns.handler_chain.array;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 15:27
 */
public class HandlerA implements Handler {
    @Override
    public boolean handle() {
        System.out.println("this is A ~~~");
        return false;
    }
}
