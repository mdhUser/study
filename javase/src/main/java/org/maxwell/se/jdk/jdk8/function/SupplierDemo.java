package org.maxwell.se.jdk.jdk8.function;

import java.util.function.Supplier;

/**
 * @description:工厂型接口
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 10:21
 */
public class SupplierDemo {

    public static void main(String[] args) {

        //todo 普通创建实例方式
//        Student student = new Student();

        Student student=getNew();

    }

    public static Student getNew() {
        Supplier<Student> supplier = () -> new Student();
        return supplier.get();
    }

}

class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}