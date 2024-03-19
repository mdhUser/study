package org.maxwell.datastructuresAndAlgorithms.timewheel;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/18 19:47
 */
public class TimerTaskList implements Delayed {

    private ReentrantLock lock = new ReentrantLock();

    private TimerTaskEntry root = new TimerTaskEntry(null, -1);

    private AtomicLong expiration = new AtomicLong(-1L);


    {
        root.next = root;
        root.prev = root;
    }


    public long getExpiration() {
        return expiration.get();
    }


    public boolean addTask(TimerTaskEntry entry) {
        boolean done = false;
        while (!done) {
            // 如果TimerTaskEntry已经在别的list中就先移除,同步代码块外面移除,避免死锁,一直到成功为止
            entry.remove();
            lock.lock();
            if (entry.timerTaskList == null) {
                entry.timerTaskList = this;
                TimerTaskEntry tail = root.prev;
                entry.prev = tail;
                entry.next = root;
                tail.next = entry;
                root.prev = entry;
                done = true;
            }
            lock.unlock();
        }
        return true;
    }


    /**
     * 设置bucket的过期时间,设置成功返回true
     *
     * @param expirationMs
     * @return
     */
    public boolean setExpiration(long expirationMs) {
        return expiration.getAndSet(expirationMs) != expirationMs;
    }


    /**
     * 从 TimedTaskList 移除指定的 timerTaskEntry
     *
     * @param entry
     */
    public void remove(TimerTaskEntry entry) {
        lock.lock();
        if (this.equals(entry.getTimerTaskList())) {
            entry.next.prev = entry.prev;
            entry.prev.next = entry.next;
            entry.next = null;
            entry.prev = null;
            entry.timerTaskList = null;
        }
        lock.unlock();
    }

    /**
     * 移除所有
     */
    public synchronized void clear(Consumer<TimerTaskEntry> entry) {
        TimerTaskEntry head = root.next;
        while (!head.equals(root)) {
            remove(head);
            entry.accept(head);
            head = root.next;
        }
        expiration.set(-1L);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return Math.max(0, unit.convert(expiration.get() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof TimerTaskList list) {
            return Long.compare(expiration.get(), list.expiration.get());
        }
        return 0;
    }


}
