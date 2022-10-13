package org.maxwell.se.base.collection;

import java.util.TreeSet;

/**
 * @description: TreeSet排序方法
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/19 22:25
 */
public class Cat {
    int age;

    public Cat(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return age+"";
    }



    public static void main(String[] args) {

        TreeSet<Cat> set = new TreeSet<>((c1, c2) -> c1.age - c2.age);

        set.add(new Cat(23));
        set.add(new Cat(43));
        set.add(new Cat(13));
        set.add(new Cat(59));
        set.add(new Cat(39));

        set.forEach(System.out::println);

    }
}
