package org.maxwell.se.jdk.jdk8.other;

import java.util.Optional;

/**
 * @description: Optional类操作
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 8:56
 */
public class OptionalDemo {


    public static void main(String[] args) {

//        Hero hero = new Hero();
//        Optional<Hero> opt = Optional.ofNullable(hero);
//        System.out.println("opt = " + opt);
//        System.out.println(opt.isPresent());
//
//        if (opt.isPresent()) {
//            System.out.println("optional不为空");
//            Hero hero1 = opt.get();
//        } else {
//            System.out.println("optional为空");
//        }


        /**
         * orElse兜底方法
         */
//        Hero hero = null;
//        Hero hero1 = new Hero("Loy");
//        Hero result = Optional.ofNullable(hero).orElse(hero1);
//        System.out.println("result = " + result);


        Hero hero = new Hero();
        String result = Optional.ofNullable(hero).map(o -> o.getName()).orElse("无名氏");
        System.out.println("result = " + result);

    }
}