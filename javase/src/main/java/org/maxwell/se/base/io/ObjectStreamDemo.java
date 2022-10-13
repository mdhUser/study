package org.maxwell.se.base.io;

import org.maxwell.se.base.other.exam.User;

import java.io.*;

/**
 * @description: 对象操作流
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/16 17:36
 */
public class ObjectStreamDemo {

    static User user = new User("张雪峰", "31415926");

    public static void main(String[] args) throws IOException {
//        out();
        in();
    }


    public static void out() throws IOException {

        try (
                FileOutputStream fos = new FileOutputStream("src/com/maxwell/obj.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {

            oos.writeObject(user);

        }

    }

    public static void in() throws IOException {

        try (
                FileInputStream fis = new FileInputStream("src/com/maxwell/obj.txt");
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {

            Object object = ois.readObject();
            User user= (User) object;
            System.out.println("user = " + user);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}