package org.maxwell.designpatterns;

import java.io.OutputStream;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/9/21 22:20
 */
public interface ILog {
    enum Type {
        LOW,
        MEDIUM,
        HIGH
    }

    interface InILog {
        void initInLog();
    }

    default void init() {
        Type t = Type.LOW;
        System.out.println(t.ordinal());
    }

    static void OS() {
        System.out.println(System.getProperty("os.name", "linux"));
    }

    void log(OutputStream out);
}

class ConsoleLog implements ILog, ILog.InILog {
    @Override
    public void log(OutputStream out) {
        System.out.println("ConsoleLog...");
    }

    public static void main(String[] args) {
        ILog log = new ConsoleLog();
        log.log(null);
        log.init();
        ILog.OS();
    }

    @Override
    public void initInLog() {
        System.out.println("fuck");
    }
}