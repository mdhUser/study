package org.maxwell.juc.completionservice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.maxwell.juc.Utils;

import java.util.concurrent.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/2 21:03
 */
@Slf4j
public class CompletionServiceDemo {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            8, 8,
            1000,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            new ThreadFactoryBuilder().setNameFormat("tl-%d")
                    //设置异常捕捉
                    .setUncaughtExceptionHandler((t, e) -> log.error("ThreadPool {} got exception", t, e))
                    .build(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    static {
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new CompletionServiceDemo().testInquiry();
    }


    CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPoolExecutor,
            new LinkedBlockingQueue<>(10));


    public  void testInquiry() throws InterruptedException, ExecutionException {

         completionService.submit(this::getPrice);
         completionService.submit(this::getPrice);
         completionService.submit(this::getPrice);

        for (int i = 0; i < 3; i++) {
            Integer integer = completionService.take().get();
            System.out.println("商品售价："+integer);
        }

    }

    private Integer getPrice() {
        int i = ThreadLocalRandom.current().nextInt(1, 50 + 1);
        Utils.sleep(i,TimeUnit.SECONDS);
        return i;
    }


}
