package org.maxwell.wrongcase.oop_18.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/6 20:59
 */

@Slf4j
public class AnnotationApp {


    @My("Class")
    static class Parent {
        @My("Method")
        public void foo() {

        }
    }

    static class Child extends Parent {
        @Override
        public void foo() {
        }
    }


    private static String getAnnotationValue(My annotation) {
        if (annotation == null) return "";
        return annotation.value();
    }


    private static void spring4MethodAnnotation() throws NoSuchMethodException {
        //获取子类的类和方法上的注解
        Child child = new Child();
        log.info("ChildClass:{}", getAnnotationValue(AnnotatedElementUtils.findMergedAnnotation(child.getClass(), My.class)));
        log.info("ChildMethod:{}", getAnnotationValue(AnnotatedElementUtils.findMergedAnnotation(child.getClass().getMethod("foo"), My.class)));
    }

    public static void test() throws NoSuchMethodException {
        //获取父类的类和方法上的注解
        Parent parent = new Parent();
        log.info("ParentClass:{}", getAnnotationValue(parent.getClass().getAnnotation(My.class)));
        log.info("ParentMethod:{}", getAnnotationValue(parent.getClass().getMethod("foo").getAnnotation(My.class)));

        //获取子类的类和方法上的注解
        Child child = new Child();
        log.info("ChildClass:{}", getAnnotationValue(child.getClass().getAnnotation(My.class)));
        log.info("ChildMethod:{}", getAnnotationValue(child.getClass().getMethod("foo").getAnnotation(My.class)));
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //test();
        spring4MethodAnnotation();
    }

}
