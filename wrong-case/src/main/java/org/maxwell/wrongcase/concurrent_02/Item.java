package org.maxwell.wrongcase.concurrent_02;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/5 10:53
 */
@Data
@RequiredArgsConstructor
public class Item {

    final String name;

    int remaining = 1000;

    @ToString.Exclude
    ReentrantLock lock = new ReentrantLock();

    static List<Item> items = new ArrayList<>();

    static {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            items.add(new Item("商品-" + i));
        });
    }


}
