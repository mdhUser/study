package org.maxwell.se.base.thread;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description: sad
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 23:47
 */
public class MyMonitorThread implements Runnable {

    private ThreadPoolExecutor executor;

    private int seconds;

    private boolean run = true;

    public MyMonitorThread(ThreadPoolExecutor executor, int delay) {
        this.executor = executor;
        this.seconds = delay;
    }

    public void shutdown(){
        this.run=false;
    }

    @Override
    public void run() {



    }
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() + "is rejected");
    }

}