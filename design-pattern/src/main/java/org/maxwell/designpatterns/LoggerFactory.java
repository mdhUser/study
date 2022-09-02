package org.maxwell.designpatterns;

/**
 * @description: 日志工厂接口
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/30 16:45
 */
public interface LoggerFactory {

    /**
     * 创建日志类
     *
     * @return
     */
    Logger createLogger();

}
