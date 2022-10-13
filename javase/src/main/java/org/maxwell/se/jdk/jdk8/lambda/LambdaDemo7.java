package org.maxwell.se.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @description: forEach
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 16:16
 */
public class LambdaDemo7 {

    public static void main(String[] args) {

        List<Student> student = Arrays.asList(new Student(15),
                new Student(14), new Student(21), new Student(25), new Student(33));

        //todo forEach循环不能调用到外部变量（return,break语句无意义）
//        student.forEach(s-> System.out.println(s.getAge()));
          student.forEach(out::println);

    }

}
