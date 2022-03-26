package com.maxwell.algorithm;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/16 10:52
 */
public class RecursionDemo {

    static Integer total = 1;


    /**
     * 求阶乘法1
     *
     * @param num
     */
    public static void factorial(Integer num) {
        total *= num;
        if (num > 1) factorial(num - 1);
        else System.out.println(total);
    }

    /**
     * 阶乘法2
     *
     * @param num
     * @return
     */
    public static long jc(Integer num) {
        if (num == 1) return 1;
        else return num * jc(num - 1);
    }

    public static void main(String[] args) {

        System.out.println(go(100));

    }

    /**
     * 递归走台阶
     *
     * @param step
     * @return a
     */
    public static int go(int step) {
        if (step >= 1) {
            if (step == 1) return 1;
            else if (step == 2) return 1 + go(step - 1);
            else if (step == 3) return 1 + go(step - 1) + 1;
            else return go(step - 1) + go(step - 2) + go(step - 3);
        } else {
            return -1;
        }
    }


}