package org.maxwell.jvm;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/9/10 22:55
 */
public class TestJVMOld {

    public static void main(String[] args) {

        byte[] array = new byte[2 * 1024 * 1024];
        array = new byte[2 * 1024 * 1024];
        array = new byte[2 * 1024 * 1024];
        array = null;
        byte[] array1 = new byte[128 * 1024];
        byte[] array2 = new byte[2 * 1024 * 1024];
    }

}
