package org.maxwell.algorithm.字符串;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/9/29 17:25
 */
public class Solution_面试题0109_字符串轮转 {

    //"waterbottle"
    //"erbottlewat"
    public static boolean isFlipedString(String s1, String s2) {

        if (s1.length()!=s2.length())
            return false;


        String rotateStr = s2 + s2;
        return rotateStr.contains(s1);
    }

    public boolean isFlipedStringLeetcode(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m != n) {
            return false;
        }
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (s1.charAt((i + j) % n) != s2.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {



    }

}
