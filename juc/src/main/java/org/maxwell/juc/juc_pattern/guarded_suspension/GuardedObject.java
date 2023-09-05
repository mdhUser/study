package org.maxwell.juc.juc_pattern.guarded_suspension;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/25 14:58
 */
public class GuardedObject<T> {

    //保证内存可见性
    volatile T obj;

    final Lock lock = new ReentrantLock();

    final Condition done = lock.newCondition();

    final int timeout = 1;

    final static Map<Object, GuardedObject<?>> gos = new ConcurrentHashMap<>();


    //静态方法创建GuardedObject
    static <K, E> GuardedObject<E> create(K key) {
        GuardedObject<E> go = new GuardedObject<>();
        gos.put(key, go);
        return go;
    }

    static <K, T> void fireEvent(K key, T obj) {
        GuardedObject go = gos.remove(key);
        if (go != null) {
            go.onChanged(obj);
        }
    }

    /**
     * 获取受保护方法
     *
     * @param p
     * @return
     */
    T get(Predicate<T> p) {
        lock.lock();
        try {
            //mesa管程推荐写法
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        //返回非空保护对象
        return obj;
    }

    //事件通知方法
    void onChanged(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }

    }


}
