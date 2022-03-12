package com.maxwell.jdk.jdk8.other;

import java.util.function.Consumer;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 13:31
 */
public class Test {

    public static void main(String[] args) {

        Consumer<Double> consumer = d -> {
            for (int i = 0; i < 120; i++) {
                d *= (1 + 0.01);
            }
            System.out.println(d);
        };
        consumer.accept(20000d);

    }
}