package org.maxwell.juc.breakdeadlock.applyall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/6 17:07
 */
public class Allocator {
    private Allocator() {
    }

    //静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
    private static final class InstanceHolder {
        private static final Allocator instance = new Allocator();
    }

    public static Allocator getInstance() {
        return InstanceHolder.instance;
    }

    /**
     * 锁容器
     */
    private List<Object> als = new ArrayList<>();

    /**
     * 申请锁资源
     *
     * @param from
     * @param to
     * @return
     */
    synchronized boolean apply(Object from, Object to) {
        if (als.contains(from) || als.contains(to))
            return false;
        als.add(from);
        als.add(to);
        return true;
    }

    /**
     * 高并发情况下使用等待通知机制防止CPU长时间空转
     */
    synchronized void applyWaitNotify(Object from, Object to) {
        while (als.contains(from) || als.contains(to)) {
            try {
                //进入休眠状态，并释放锁
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        als.add(from);
        als.add(to);
    }

    //归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        this.notifyAll();
    }
}
