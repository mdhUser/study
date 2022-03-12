package com.maxwell.base.reflection;


import com.maxwell.base.entity.Hero;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 反射机制获取对象方法
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 14:23
 */
public class ClassGetMethodAndField {

    public static void main(String[] args) {


        Hero h = new Hero();


        //反射获取对象方法
        try {
            Method method=h.getClass().getMethod("setName", String.class);
            method.invoke(h,"迪迦");
            System.out.println(h.getName());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


       //反射获取对象属性
        try {
            Field field =h.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(h,"黑迪迦");
            System.out.println(field.getName()+"="+h.getName());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }


}
