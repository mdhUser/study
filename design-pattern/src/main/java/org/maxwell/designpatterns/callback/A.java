package org.maxwell.designpatterns.callback;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 10:51
 */
public class A {

    public static void main(String[] args) {
        B b = new B();
        b.proccess(() -> System.out.println("Callback me !!"));
    }

}
