package org.maxwell.juc.demo.cyclicbarrier;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * CyclicBarrierDemo
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/23 16:43
 */
public class ReconciliationService {

    //订单队列
    Vector<P> pos = new Vector<>();

    //派送单队列
    Vector<D> dos = new Vector<>();


    Executor executor = Executors.newSingleThreadExecutor();

    //计数减为0时唤醒等待线程并执行回调函数
    final CyclicBarrier barrier = new CyclicBarrier(2, () -> {
        executor.execute(() -> check());
    });

    private void check() {

        P p = pos.remove(0);
        D d = dos.remove(0);

        String diff = check(p, d);

        save(diff);

    }

    private void save(String check) {
        //省略持久化到数据库逻辑
    }

    private String check(P p, D d) {
        String diff = null;
        if (p.getAmount().compareTo(d.getAmount()) != 0) {
            diff = "金额差：" + Math.abs(p.getAmount() - d.getAmount());
        }

        if (p.getCount().compareTo(d.getCount()) != 0) {
            diff += "\t数量差：" + Math.abs(p.getCount() - d.getCount());
        }
        return diff;
    }


    void checkAll() {

        Thread t1 = new Thread(() -> {
            pos.add(getPOrders());
            try {
                //等待
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            dos.add(getDOrders());
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();
    }

    //获取派送单
    private D getDOrders() {
        return null;
    }

    //获取订单
    private P getPOrders() {
        return null;
    }


}
