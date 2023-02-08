package org.maxwell.wrongcase;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/1 20:30
 */
public class WrongCaseTest {

    //帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
    private ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed().collect(Collectors.toConcurrentMap(
                        i -> UUID.randomUUID().toString(), Function.identity(),
                        (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    @Test
    void test() {
        ConcurrentHashMap<String, Long> data = getData(-1);
        data.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }


    @Test
    public void test01(){
        System.out.println(IntStream.rangeClosed(1, 100).boxed().reduce(0, Integer::sum));
    }

}
