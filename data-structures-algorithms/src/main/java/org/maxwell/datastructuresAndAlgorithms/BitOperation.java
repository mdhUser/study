package org.maxwell.datastructuresAndAlgorithms;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/3 16:54
 */
public class BitOperation {

    public static void main(String[] args) {

        //等于2乘以2的3次方
        int a = 2 << 3;
        //等于2除以2的1次方忽略符号空位补0
        int b = 2 >>> 1;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


}
