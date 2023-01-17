package org.maxwell.wrongcase.concurrent_03;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/12 16:14
 */
public class ThreadPoolConfig {

    /**
     * 而对于吞吐量较大的计算型任务，线程数量不宜过多，可以是 CPU 核数或核数 *2 一般是核数或者核数+1（理由是，线程一定调度到某个 CPU 进行执行，如果任务本身是 CPU 绑定的任务，
     * 那么过多的线程只会增加线程切换的开销，并不能提升吞吐量），
     * 但可能需要较长的队列来做缓冲。
     */
    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            2, 2,
            1, TimeUnit.HOURS,
            new LinkedBlockingDeque<>(100),
            new ThreadFactoryBuilder().setNameFormat("process-threadpool-%d").build(),
            new ThreadPoolExecutor.AbortPolicy()
    );


    /**
     * IO绑定型操作 线程数多 队列大 防止阻塞Tomcat的线程 导致服务崩溃
     */
    private static final ThreadPoolExecutor asyncThreadPool = new ThreadPoolExecutor(
            200, 200,
            1, TimeUnit.HOURS,
            new LinkedBlockingDeque<>(1000),
            new ThreadFactoryBuilder().setNameFormat("aysnccalc-threadpool-%d").build()
    );

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }

    public static ThreadPoolExecutor getAsyncThreadPool() {
        return asyncThreadPool;
    }


}
