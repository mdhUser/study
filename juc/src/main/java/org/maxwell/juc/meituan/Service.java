package org.maxwell.juc.meituan;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/19 12:40
 */

public class Service {


    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            20, 20, 1000, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(100)
    );

    static Object lock = new Object();

    public static Map<Long, String> get(List<Long> userIds) throws InterruptedException {
        UserService userService = new UserService();
        Map<Long, String> resultMap = new HashMap<>(1000);

        //记录已度过的切片
        AtomicInteger pointer = new AtomicInteger(0);
        ConcurrentHashMap<Long, String> userIdNickNameMap = new ConcurrentHashMap<>();
        //等待响应任务数
        CountDownLatch countDownLatch = new CountDownLatch(20);
        while (pointer.get() < 1000) {
            threadPool.submit(() -> {
                List<Long> longs;
                synchronized (lock) {
                    int fromIndex = pointer.get();
                    longs = userIds.subList(fromIndex, fromIndex + 50);
                    pointer.getAndAdd(50);
                }
                //模拟数据库查询
                userIdNickNameMap.putAll(userService.getUserMap(longs));
                countDownLatch.countDown();
            });
        }

        //等待线程池任务执行完成
        countDownLatch.await();
        //查询并放入结果集
        for (Long userId : userIds) {
            String name = userIdNickNameMap.get(userId);
            if (name != null && !name.isEmpty()) {
                resultMap.put(userId, name);
            }
        }

        return resultMap;
    }


    public static List<Long> generateRandomIds(int count) {
        List<Long> randomIds = new ArrayList<>();
        Random random = new Random();
        // 生成指定数量的随机ID
        for (int i = 0; i < count; i++) {
            long randomId = Math.abs(random.nextLong());
            randomIds.add(randomId);
        }
        return randomIds;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Long> userIds = generateRandomIds(1000);
        long start = System.currentTimeMillis();
        Map<Long, String> longStringMap = get(userIds);
        System.out.println("---costTime: " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(longStringMap +"数量="+longStringMap.size());
        threadPool.shutdown();
    }

    static class UserService {
        public Map<Long, String> getUserMap(List<Long> userIds) {
            if (userIds == null || userIds.size() > 50) {
                throw new RuntimeException("userIds more than 50");
            }
            Map<Long, String> result = new HashMap<>();
            for (Long userId : userIds) {
                result.put(userId, "test");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("抛出异常");
                throw new RuntimeException(e);
            }
            return result;
        }
    }


}
