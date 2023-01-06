package org.maxwell.wrongcase.concurrent_02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/5 11:16
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;


    /**
     * 死锁
     *
     * @return
     */
    @GetMapping("/wrong")
    public long wrong() {
        long begin = System.currentTimeMillis();
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(i -> {
                    List<Item> cart = orderService.createCart();
                    return orderService.createOrder(cart);
                }).filter(result -> result)
                .count();
        log.info("success:{} totalRemaining:{} took:{}ms items:{}", success, Item.items.stream().map(item -> item.remaining)
                .reduce(0, Integer::sum), System.currentTimeMillis() - begin, Item.items);
        return success;
    }


    @GetMapping("/right")
    public long right() {
        long begin = System.currentTimeMillis();
        long success = IntStream.rangeClosed(1, 100).parallel()
                .mapToObj(__ -> {
                    List<Item> cart = orderService.createCart().
                            stream().sorted(Comparator.comparing(Item::getName))
                            .collect(Collectors.toList());
                    return orderService.createOrder(cart);
                }).filter(result -> result)
                .count();
        log.info("success:{} totalRemaining:{} took:{}ms items:{}", success, Item.items.stream().map(item -> item.remaining)
                .reduce(0, Integer::sum), System.currentTimeMillis() - begin, Item.items);
        return success;
    }

}
