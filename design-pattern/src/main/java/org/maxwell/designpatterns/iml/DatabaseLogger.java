package org.maxwell.designpatterns.iml;

import org.maxwell.designpatterns.Logger;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/30 16:42
 */
public class DatabaseLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("数据库日志记录");
    }

}
