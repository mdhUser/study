package org.maxwell.algorithm.medium;

/**
 * @description: 不用+号的+法
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/16 16:20
 */

public class Solution_add {

    public static void main(String[] args) {
        System.out.println(getSum(5, 6));
        System.out.println(divide(-2147483648,
                -1));
    }

    public int mySqrt(int x) {
        double sqrt = Math.sqrt(x);
        return (int) sqrt;
    }

    public static int getSum(int a, int b) {

        while (b != 0) {
            int add = (a & b) << 1;
            a = a ^ b;
            b = add;
        }
        return a;
    }

    /**
     *  一般的除法
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        return (int) Math.ceil(dividend / divisor);
    }

}
