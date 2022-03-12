package com.maxwell.jdk.jdk8.function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @description: 断言型接口
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 10:27
 */
public class PredicateDemo {


    public static void main(String[] args) {

        List<String> list = Arrays.asList("sadaf", "jbnku8wyenjk", "as44332"
                , "awwa", "dsssdfa", "xsdasd");
        List<String> results = filter(list,l->l.startsWith("a"));
        results.stream().forEach(l-> System.out.println(l));

    }

    public static List<String> filter(List<String> list, Predicate<String> predicate) {
        List<String> results = new ArrayList<>();
        list.forEach(s -> {
            if (predicate.test(s)) {
                results.add(s);
            }
        });
        return results;

    }

}
