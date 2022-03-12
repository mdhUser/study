package com.maxwell.jdk.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/23 14:25
 */
public class LambdaDemo5 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(new Student(51), new Student(86), new Student(24), new Student(23), new Student(4));


        //todo 取出最大值
//        Optional<Student> student = students.stream().max(Comparator.comparingInt(Student::getAge));
        Optional<Student> student = students.stream().min((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println(student.get().getAge());


    }


}

class Student {

    private int age;

    private String province;


    public Student() {
    }

    public Student(String province, int age) {
        this.age = age;
        this.province = province;
    }


    public Student(int age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "age=" + age + '}';
    }
}