package org.maxwell.wrongcase.answer_07;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 激进线程池
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/18 15:58
 */
public class RadicalThreadPool {

    private static BlockingDeque<Runnable> queue = new LinkedBlockingDeque<Runnable>(10) {
        @Override
        public boolean offer(Runnable runnable) {
            //先返回false 造成队列已满假象
            return false;
        }
    };

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            2, 5,
            5, TimeUnit.SECONDS,
            queue, new ThreadFactoryBuilder().setNameFormat("radical-threadpool-%d").build(),
            (run, exe) -> {
                try {
                    //真正塞入队列
                    if (!exe.getQueue().offer(run, 0, TimeUnit.SECONDS)) {
                        throw new RejectedExecutionException("ThreadPool queue full,failed to offer " + run.toString());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

    public static ThreadPoolExecutor get() {
        return threadPool;
    }


}
