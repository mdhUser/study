package com.maxwell.base.recursion;

import java.io.File;

import static com.maxwell.base.recursion.FileRecursion.deleteALlFile;

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
        if (num > 1)
            factorial(num - 1);
        else
            System.out.println(total);
    }

    /**
     * 阶乘法2
     *
     * @param num
     * @return
     */
    public static long jc(Integer num) {
        if (num == 1)
            return 1;
        else
            return num * jc(num - 1);
    }

    public static void main(String[] args) {
        factorial(5);
        System.out.println(jc(6));
        deleteALlFile(new File("D:\\LOL"));

    }





}