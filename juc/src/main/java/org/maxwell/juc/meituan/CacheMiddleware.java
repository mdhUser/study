package org.maxwell.juc.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class CacheMiddleware<K, V> {
    private Map<K, V> cacheMap;
    private Map<K, Future<V>> futureMap;
    private ExecutorService executorService;
    private AService aService;
    private long expirationTime; // 缓存过期时间，单位：毫秒

    public CacheMiddleware(AService aService, long expirationTime) {
        this.cacheMap = new HashMap<>();
        this.futureMap = new HashMap<>();
        this.executorService = Executors.newFixedThreadPool(10);
        this.aService = aService;
        this.expirationTime = expirationTime;
    }

    public V get(K key) throws ExecutionException, InterruptedException {
        V value = cacheMap.get(key);
        if (value == null) {
            Future<V> future = futureMap.get(key);
            if (future == null) {
                Callable<V> callable = () -> (V) aService.get(key);
                future = executorService.submit(callable);
                futureMap.put(key, future);
            }
            try {
                //阻塞等待获取数据
                value = future.get();
                // 数据获取成功后，更新到缓存中
                cacheMap.put(key, value);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                // 移除 Future 对象
                futureMap.remove(key);
            }
        }
        return value;
    }

    public void put(K key, V value) {
        cacheMap.put(key, value);
        scheduleExpiration(key);
    }

    public void remove(K key) {
        cacheMap.remove(key);
        futureMap.remove(key);
    }

    public void update(K key) throws ExecutionException, InterruptedException {
        //更新缓存
        Callable<V> callable = () -> (V) aService.get(key);
        Future<V> future = executorService.submit(callable);
        futureMap.put(key, future);
        scheduleExpiration(key);
    }

    private void scheduleExpiration(K key) {
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutor.schedule(() -> {
            cacheMap.remove(key);
        }, expirationTime, TimeUnit.MILLISECONDS);
        scheduledExecutor.shutdown();
    }


    static class AService<K> {
        public <V> V get(K key) {
            return (V) (key.toString() + "test");
        }
    }

}