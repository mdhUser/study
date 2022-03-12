package com.maxwell.base.api;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 15:34
 */
public class StringTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = sb.append(1);

        System.out.println("sb1 = " + sb1);
        String a ="dasfaf";
        String s = String.format("%s你好SD",a);
        System.out.println("s = " + s);




    }
}