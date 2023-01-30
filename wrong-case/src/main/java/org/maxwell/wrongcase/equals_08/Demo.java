package org.maxwell.wrongcase.equals_08;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/25 20:39
 */
@Slf4j
public class Demo {


    @Data
    @AllArgsConstructor
    static class Student implements Comparable<Student> {

        private int id;

        private String name;

        @Override
        public int compareTo(Student other) {
            //int result = Integer.compare(other.id, id);
            //if (result == 0) log.info("this {} == other {}", this, other);
            //return result;
            //right
            return Comparator.comparing(Student::getName).thenComparingInt(Student::getId).compare(this, other);
        }
    }

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "zhang"));
        list.add(new Student(2, "wang"));
        Student student = new Student(2, "li");
        log.info("ArrayList.indexOf");
        int index1 = list.indexOf(student);
        Collections.sort(list);
        System.out.println(list);
        log.info("Collections.binarySearch");
        int index2 = Collections.binarySearch(list, student);
        log.info("index1 = " + index1);
        log.info("index2 = " + index2);
    }


}
