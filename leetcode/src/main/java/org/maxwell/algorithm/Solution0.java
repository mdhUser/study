package org.maxwell.algorithm;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/29 21:48
 */
public class Solution0 {


    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }

    public static String replaceSpace(String s) {
        String replace = s.replace(" ", "%20");
        return replace;
    }




}

