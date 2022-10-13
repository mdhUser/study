package org.maxwell.se.jdk.jdk14;

/**
 * @description:  14开始 判断instanceof后，可以直接转型为指定变量，避免再次强制转型。
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/12 9:22
 */
public class Person {

    public static void main(String[] args) {

        Object obj ="Hello";
        if (obj instanceof String s)
            System.out.println(s.toUpperCase());

    }

}
