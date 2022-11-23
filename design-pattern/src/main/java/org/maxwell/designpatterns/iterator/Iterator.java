package org.maxwell.designpatterns.iterator;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/22 14:51
 */
public interface Iterator<E> {

    /**
     * 是否有下一个
     *
     * @return
     */
    boolean hasNext();

    /**
     * 下一个元素
     */
    void next();

    /**
     * 当前元素
     *
     * @return
     */
    E currentItem();

}
