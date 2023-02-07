package org.maxwell.wrongcase.oop_18.generic_reflection;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/6 16:39
 */
public class Demo {
    public static void main(String[] args) {
        wrong();
        //right();
    }

    private static void right() {
        Child02 child = new Child02();
        Arrays.stream(child.getClass().getDeclaredMethods())
                //判断是否是桥接方法 泛型擦除时会置为Object
                .filter(m -> "setValue".equals(m.getName()) && !m.isBridge())
                .findFirst().ifPresent(method -> {
                    try {
                        method.invoke(child, "test");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.println(child);
    }


    private static void wrong() {
        Child02 child = new Child02();
        Arrays.stream(child.getClass().getDeclaredMethods()).filter(m -> m.getName().equals("setValue"))
                .forEach(method -> {
                    try {
                        method.invoke(child, "Child01");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        System.out.println(child);
    }

}

class Parent<T> {

    private AtomicInteger modCount = new AtomicInteger(0);
    private T value;

    @Override
    public String toString() {
        return String.format("value: %s updateCount: %d", value, modCount.get());
    }

    public void setValue(T value) {
        System.out.println("Parent.setValue called");
        this.value = value;
        modCount.incrementAndGet();
    }
}

class Child01 extends Parent {
    public void setValue(String str) {
        System.out.println("Child01.setValue called");
        super.setValue(str);
    }
}

class Child02 extends Parent<String> {
    @Override
    public void setValue(String value) {
        System.out.println("Child02.setValue called");
        super.setValue(value);
    }
}