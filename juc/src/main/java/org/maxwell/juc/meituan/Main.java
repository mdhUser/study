package org.maxwell.juc.meituan;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
class ScoredItems {
    public Object item;
    public double score;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

interface Scorer {
    public List<ScoredItems> score(List<Object> items);
}

public class Main {
    private Scorer scorer;

    // 通过调用scorer实现该方法，items数量最多为10000
    // scorer会调用一个RPC服务，该服务一次只接受100个item
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    private Object lock = new Object();

    public List<Object> sort(List<Object> items) throws InterruptedException {
        int size = items.size();
        int times = size % 100 == 0 ? size / 100 : size / 100 + 1;
        CountDownLatch countDownLatch = new CountDownLatch(times);
        //记录已度过的切片
        AtomicInteger pointer = new AtomicInteger(0);
        List<ScoredItems> result = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            executorService.submit(() -> {
                List<Object> longs;
                synchronized (lock) {
                    int fromIndex = pointer.get();
                    longs = items.subList(fromIndex, fromIndex + 100);
                    pointer.getAndAdd(100);
                }
                List<ScoredItems> score = scorer.score(longs);
                synchronized (lock) {
                    result.addAll(score);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        List<ScoredItems> scoredItems = result.stream().sorted(Comparator.comparingDouble(ScoredItems::getScore)).collect(Collectors.toList());
        Collections.reverse(scoredItems);
        return scoredItems.stream().map(ScoredItems::getItem).collect(Collectors.toList());
    }
}