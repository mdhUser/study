package com.maxwell.base.generics;

import com.maxwell.base.entity.Hero;

import java.util.ArrayList;

/**
 * @description: 测试
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/15 10:40
 */
public class Test {


    public static void iterateG(ArrayList<? extends Hero> list) {
        for (Hero hero : list)
            System.out.println(hero.getName());

    }

    public static void main(String[] args) {
//        ArrayList<Hero> hs = new ArrayList<>();
//        ArrayList<APHero> aphs = new ArrayList<>();
//        ArrayList<ADHero> adhs = new ArrayList<>();
//        hs.add(new Hero("hero1"));
//        hs.add(new Hero("hero2"));
//        hs.add(new Hero("hero3"));
//        adhs.add(new ADHero("adfuck"));
//        aphs.add(new APHero("fuckU1"));
//        adhs.add(new ADHero("fuckU2"));
//        aphs.add(new APHero("fuckU3"));
//        iterateG(hs);
//        iterateG(aphs);
//        iterateG(adhs);

        try {
//            Class c1=Hero.class;
//            Class c2=new Hero().getClass();
            Class c3=Class.forName("com.itheima.entity.Hero");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
