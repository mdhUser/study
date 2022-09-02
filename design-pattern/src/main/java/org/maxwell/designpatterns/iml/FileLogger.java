package org.maxwell.designpatterns.iml;

import org.maxwell.designpatterns.Logger;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/8/30 16:41
 */
public class FileLogger implements Logger {

    @Override
    public void writeLog() {
        System.out.println("文件日志记录");
    }

}
