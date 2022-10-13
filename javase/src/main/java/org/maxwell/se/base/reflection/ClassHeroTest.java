package org.maxwell.se.base.reflection;


import org.maxwell.se.base.entity.ADHero;
import org.maxwell.se.base.entity.APHero;
import org.maxwell.se.base.entity.Hero;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @description: 英雄反射练习
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 14:37
 */
public class ClassHeroTest {

    public static void main(String[] args) {

        APHero apHero = null;
        ADHero adHero = null;

        List<Hero> heroes = ClassConfig.getHero();
        for (Hero hero : heroes) {
            if (hero instanceof APHero) {
                apHero = (APHero) hero;
            }
            if (hero instanceof ADHero) {
                adHero = (ADHero) hero;
            }
        }

        try {
            Field field = apHero.getClass().getField("name");
            Field field2 = adHero.getClass().getField("name");
            field.set(apHero, "阿木木");
            field2.set(adHero, "剑圣");

            Method method = adHero.getClass().getMethod("attackHero", Hero.class);

            method.invoke(adHero, apHero);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }


}
