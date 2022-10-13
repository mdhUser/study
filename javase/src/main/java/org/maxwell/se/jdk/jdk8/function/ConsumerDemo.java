package org.maxwell.se.jdk.jdk8.function;


import org.maxwell.se.base.entity.Hero;

import java.util.function.Consumer;

/**
 * @description: 消费型接口
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 10:14
 */
public class ConsumerDemo {


    public static void main(String[] args) {
        Consumer<Hero> consumer = hero -> System.out.println(hero.getName());
        Hero hero = new Hero("光辉");
        consumer.accept(hero);
    }

}
