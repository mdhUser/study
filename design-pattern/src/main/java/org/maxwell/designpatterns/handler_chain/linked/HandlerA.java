package org.maxwell.designpatterns.handler_chain.linked;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 14:40
 */
public class HandlerA extends Handler {

    @Override
    public boolean doHandle() {
        boolean bool = false;
        // ...业务逻辑
        return bool;
    }
}
