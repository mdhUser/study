package org.maxwell.wrongcase.jdk8new_31;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/4/13 16:44
 */
public class MostPopularCollector<T> implements Collector<T, Map<T, Integer>, Optional<T>> {

    //使用HashMap保存中间数据
    @Override
    public Supplier<Map<T, Integer>> supplier() {
        return HashMap::new;
    }

    //每次累积数据则累加Value
    @Override
    public BiConsumer<Map<T, Integer>, T> accumulator() {
        return (acc, elem) -> acc.merge(elem, 1, Integer::sum);
    }

    //合并多个Map就是合并其Value
    @Override
    public BinaryOperator<Map<T, Integer>> combiner() {
        return (a, b) -> Stream.concat(a.entrySet().stream(), b.entrySet().stream())
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)));
    }

    //找出Map中Value最大的Key
    @Override
    public Function<Map<T, Integer>, Optional<T>> finisher() {
        return (acc) -> acc.entrySet().stream().reduce(BinaryOperator.maxBy(Map.Entry.comparingByValue())).map(Map.Entry::getKey);
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
