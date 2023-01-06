package org.maxwell.wrongcase.concurrent_02;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/5 11:22
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public boolean createOrder(List<Item> order) {
        //存放所有获得的锁
        List<ReentrantLock> locks = new ArrayList<>();
        for (Item item : order) {
            try {
                //获取锁10s超时
                if (item.lock.tryLock(10, TimeUnit.SECONDS)) {
                    locks.add(item.lock);
                } else {
                    locks.forEach(ReentrantLock::unlock);
                    return false;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //锁拿到之后执行扣减库存业务逻辑
        try {
            order.forEach(item -> item.remaining--);
        } finally {
            locks.forEach(ReentrantLock::unlock);
        }
        return true;
    }

    @Override
    public List<Item> createCart() {
        return IntStream.rangeClosed(1, 3)
                .mapToObj(i -> Item.items.get(ThreadLocalRandom.current().nextInt(Item.items.size()))).collect(Collectors.toList());
    }
}
