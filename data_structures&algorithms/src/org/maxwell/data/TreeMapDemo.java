package src.org.maxwell.data;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/29 21:50
 */
public class TreeMapDemo {
    public static void main(String[] args) {


        Student stu1=new Student(1,"max",12);
        Student stu2=new Student(4,"max",12);
        Student stu3=new Student(48,"max",12);
        Student stu4=new Student(4654,"max",12);
        Student stu5=new Student(26,"max",12);
        Student stu6=new Student(15,"max",12);

        TreeMap<Student,Integer> tree = new TreeMap(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getNo()-o2.getNo();
            }
        });

        tree.put(stu1,1);
        tree.put(stu2,2);
        tree.put(stu3,3);
        tree.put(stu4,4);
        tree.put(stu5,5);
        tree.put(stu6,6);

        System.out.println(tree);


    }

}

class Student{

    int no;
    String name;
    int age;

    public Student(int no, String name, int age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
