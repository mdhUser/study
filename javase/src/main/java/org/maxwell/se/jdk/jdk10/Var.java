package org.maxwell.se.jdk.jdk10;


import java.util.stream.Stream;

/**
 * @description: 新增类型推断var
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 13:35
 */
public class Var {

    public static void main(String[] args) {

        //String 类型
        var str = "成为大佬进大厂";
        System.out.println(str instanceof String);
        //long类型
        var longVar = 465781L;

        var flag = Boolean.valueOf("true");
        System.out.println(flag instanceof Boolean);

        for (var i = 0; i < 10; i++) {
            System.out.println(i);
        }

        var streamVar = Stream.of("aa", "bb", "cc");
        System.out.println(streamVar instanceof Stream);

        var hero = new Hero().setDamage(372678)
                .setName("迪迦");

        System.out.println("hero = " + hero.getName());


    }
}


class Hero {
    private String name;
    private int damage;

    public String getName() {
        return name;
    }

    public Hero setName(String name) {
        this.name = name;
        return this;
    }

    public int getDamage() {
        return damage;
    }

    public Hero setDamage(int damage) {
        this.damage = damage;
        return this;
    }
}