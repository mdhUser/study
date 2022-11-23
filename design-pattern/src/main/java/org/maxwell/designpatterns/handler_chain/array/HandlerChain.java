package org.maxwell.designpatterns.handler_chain.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 15:28
 */
public class HandlerChain {

    private final List<Handler> handlers = new ArrayList<>(10);

    public void addHandle(Handler handler) {
        this.handlers.add(handler);
    }

    public void handle() {
        for (Handler handler : handlers) {
            boolean handle = handler.handle();
            if (handle) {
                break;
            }
        }
    }

}
