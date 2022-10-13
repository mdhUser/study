package org.maxwell.se.base.collection;


import org.maxwell.se.base.entity.Student;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {


    public static void main(String[] args) {

        Set<Student> students = new TreeSet<>((o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getName().compareTo(o2.getName());
            } else
                return o1.getAge() - o2.getAge();
        });

        students.add(new Student("rose", 30));
        students.add(new Student("luck", 18));
        students.add(new Student("jack", 25));
        students.add(new Student("damon", 30));


        for (Student student : students) {
            System.out.println(student);
        }

        TreeSet<Integer> nums = new TreeSet<>();
        nums.add(45);
        nums.add(445);
        nums.add(1578);
        nums.add(14);
        nums.add(27);

        nums.forEach(System.out::println);

    }


}