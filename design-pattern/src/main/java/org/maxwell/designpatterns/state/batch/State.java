package org.maxwell.designpatterns.state.batch;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 16:42
 */
public enum State {
    /**
     * 马里奥状态
     */
    SMALL(0),
    SUPER(1),
    FIRE(2),
    CAPE(3),
    ;

    private final int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
