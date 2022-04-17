package org.maxwell.algorithm;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/15 21:55
 */
public class Log {


    public static void main(String[] args) {

    }

    public static boolean pow(int n) {

        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;

    }


}
