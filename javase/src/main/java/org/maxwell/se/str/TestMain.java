package org.maxwell.se.str;


/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/10/15 22:13
 */
public class TestMain {

    public static void main(String[] args) {
        String str1 = "HelloFlyapi";
        String str2 = "HelloFlyapi";
        String str3 = new String("HelloFlyapi");
        String str4 = "Hello";
        String str5 = "Flyapi";
        String str6 = "Hello" + "Flyapi";
        String str7 = str4 + str5;

        System.out.println("str1 == str2 result: " + (str1 == str2));

        System.out.println("str1 == str3 result: " + (str1 == str3));

        System.out.println("str1 == str6 result: " + (str1 == str6));

        System.out.println("str1 == str7 result: " + (str1 == str7));

        System.out.println("str1 == str7.intern() result: " + (str1 == str7.intern()));

        System.out.println("str3 == str3.intern() result: " + (str3 == str3.intern()));

    }

    private static void internQues() {
        var s1 = new StringBuilder("58").append("tt").toString();
        System.out.println(s1);
        System.out.println(s1.intern());
        System.out.println(s1.intern() == s1);

        var s2 = new StringBuilder("ja").append("va1").toString();
        System.out.println(s2);
        System.out.println(s2.intern());
        System.out.println(s2.intern() == s2);
    }

}
