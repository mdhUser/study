package org.maxwell.se.base.reflection;


import org.maxwell.se.base.entity.Hero;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:反射获取属性字段
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 11:14
 */
public class ClassConfig {

    public static void main(String[] args) {
//        Hero hero = getHero();
//        hero.setName("456");

        Hero hero2 = new Hero();
        hero2.setName("盖亚");

        try {


            /***
             * getField和getDeclaredField的区别
             * 这两个方法都是用于获取字段
             * getField 只能获取public的，包括从父类继承来的字段。
             * getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。
             * (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))
             */
//            Field field = hero2.getClass().getDeclaredField("name");
//            field.setAccessible(true);
//            System.out.println(hero2.getName());
//            field.set(hero, "迪迦");
//            System.out.println(field.getName());
//            System.out.println(hero.getName());


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static List<Hero> getHero() {
        File f = new File("F:\\workspace\\heima\\src\\hero");

        try (FileReader reader = new FileReader(f)) {
            String className = null;
            char[] cs = new char[(int) f.length()];
            reader.read(cs);
            className = new String(cs);
            List<Hero> heroes = new ArrayList<>();
            String[] strs = className.split("\r\n");
            for (String str : strs) {
                if (null != str) {
                    Class c = Class.forName(str);
                    Constructor constructor = c.getConstructor();
                    Hero hero = (Hero) constructor.newInstance();
                    heroes.add(hero);
                }
            }

            return heroes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
