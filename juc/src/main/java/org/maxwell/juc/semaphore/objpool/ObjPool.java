package org.maxwell.juc.semaphore.objpool;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * 简易对象池
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/18 22:51
 */
public class ObjPool<T, R> {

    final List<T> pool;

    final Semaphore semaphore;

    /**
     * 初始化对象池和限流数
     *
     * @param size
     * @param t
     */
    public ObjPool(int size, T t) {
        //有多个线程并发执行故而需要用线程安全的Vector
        pool = new Vector<>();
        IntStream.rangeClosed(1, size).forEach(__ -> pool.add(t));
        semaphore = new Semaphore(size);
    }


    /**
     * 利用对象池的对象，调用func
     *
     * @param func
     * @return
     */
    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ObjPool<String, String> objPool = new ObjPool<>(10,"test");


        objPool.exec(t->{
            System.out.println(t);
            return t;
        });

    }

}
