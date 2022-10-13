package org.maxwell.se.oop;

/**
 * @description: 测试oop中的属性指向
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/19 12:10
 */
public class Son extends Pap {

    String name = "son";

    @Override
    void speak() {
        System.out.println("i'm son");
    }

    void sot() {
        System.out.println(super.name);
    }

    public static void main(String[] args) {
        Son p = new Son();
        System.out.println(p.name);
        p.sot();
        p.speak();
    }

}

class Pap {

    String name = "father";
    byte age;

    void speak() {
        System.out.println("I'm father");
    }

}