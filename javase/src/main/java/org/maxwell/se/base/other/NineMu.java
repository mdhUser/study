package org.maxwell.se.base.other;

/**
 * @description: 九九乘法表
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/16 9:12
 */
public class NineMu {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "X" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }


}
