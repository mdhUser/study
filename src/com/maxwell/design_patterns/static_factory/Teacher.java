package com.maxwell.design_patterns.static_factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 16:51
 */
public class Teacher {
    private String name;

    private Teacher(String name) {
        this.name = name;
    }

    //todo 可创建实例数
    private static final int COUNT = 3;
    //TODO 存放实例集合
    private static final List<Teacher> LIST = new ArrayList<>();

    //todo 初始化教师集合
    static {
        for (int i = 0; i < COUNT; i++) {
            LIST.add(new Teacher("teacher" + (i + 1)));
        }
    }

    //TODO 获取随机教师实例
    public static Teacher getTeacher() {
        return LIST.get((int) (Math.random() * 3));
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Test {

    public static void main(String[] args) {

        System.out.println(Teacher.getTeacher());

    }

}