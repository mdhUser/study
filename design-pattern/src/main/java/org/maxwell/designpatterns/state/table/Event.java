package org.maxwell.designpatterns.state.table;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/21 09:11
 */
public enum Event {

    /**
     * 马里奥事件
     */
    GET_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3),
    ;

    private final int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
