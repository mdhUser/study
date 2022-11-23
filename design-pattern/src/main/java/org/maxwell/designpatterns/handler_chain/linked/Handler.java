package org.maxwell.designpatterns.handler_chain.linked;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 14:36
 */
public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public final void handle() {
        boolean b = doHandle();
        if (!b && successor != null) {
            successor.handle();
        }
    }

    /**
     * 处理逻辑
     */
    public abstract boolean doHandle();

}
