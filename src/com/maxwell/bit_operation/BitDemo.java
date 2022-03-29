package com.maxwell.bit_operation;

import org.junit.Test;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/28 15:31
 */
public class BitDemo {

    @Test
    public void test() {
        int i = 3 & 5;
        int i1 = Integer.valueOf("0101", 2);
        System.out.println(i1);

        String s = Integer.toBinaryString(10);
        System.out.println(s);
    }

}
