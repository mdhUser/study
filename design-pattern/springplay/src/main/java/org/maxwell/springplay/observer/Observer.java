package org.maxwell.springplay.observer;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/12/14 22:14
 */
public interface Observer {
    void notify(String bizType, String content);

}
