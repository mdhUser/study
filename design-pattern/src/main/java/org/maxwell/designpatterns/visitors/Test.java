package org.maxwell.designpatterns.visitors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/24 14:54
 */
public class Test {


    public static class ParentClass {
        public void f() {
            System.out.println("I am ParentClass's f().");
        }
    }

    public static class ChildClass extends ParentClass {
        public void f() {
            System.out.println("I am ChildClass's f().");
        }
    }

    public static class SingleDispatchClass {
        //public void polymorphismFunction(ParentClass p) {
        //    p.f();
        //}
        //
        //public void overloadFunction(ParentClass p) {
        //    System.out.println("I am overloadFunction(ParentClass p).");
        //}
        //
        //public void overloadFunction(ChildClass c) {
        //    System.out.println("I am overloadFunction(ChildClass c).");
        //}
        public void polymorphismFunction(ParentClass p) {
            p.f();
        }

        public void overloadFunction(ParentClass p) {
            p.f();
        }

        public void overloadFunction(ChildClass c) {
            c.f();
        }
    }


    public static void main(String[] args) {
        SingleDispatchClass demo = new SingleDispatchClass();
        ParentClass p = new ChildClass();
        demo.polymorphismFunction(p);//执行哪个对象的方法，由对象的实际类型决定
        demo.overloadFunction(p);//执行对象的哪个方法，由参数对象的声明类型决定
    }


}
