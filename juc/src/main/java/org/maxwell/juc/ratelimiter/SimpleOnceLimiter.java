package org.maxwell.juc.ratelimiter;

import java.util.concurrent.TimeUnit;

import static java.lang.Math.max;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/6 10:20
 */
public class SimpleOnceLimiter {

    //下一令牌产生时间
    long next = System.nanoTime();
    //发放令牌间隔：纳秒
    long interval = 1000_000_000;

    //预占令牌，返回能够获取令牌的时间
    synchronized long reserve(long now) {
        //请求时间在下一令牌产生时间之后
        //重新计算下一令牌产生时间
        if (now > next) {
            //将下一令牌产生时间重置为当前时间
            next = now;
        }
        //能够获取令牌的时间
        long at = next;
        //设置下一令牌产生时间
        next += interval;
        //返回线程需要等待的时间
        return max(at, 0L);
    }

    //申请令牌
    void acquire() {
        //申请令牌时的时间
        long now = System.nanoTime();
        //预占令牌
        long at = reserve(now);
        long waitTime = max(at - now, 0);
        //按照条件等待
        if (waitTime > 0) {
            try {
                TimeUnit.NANOSECONDS
                        .sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
