package org.maxwell.designpatterns.iml;

import org.maxwell.designpatterns.Logger;
import org.maxwell.designpatterns.LoggerFactory;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/30 16:48
 */
public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
