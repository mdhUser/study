package com.maxwell.base.recursion;

import java.io.File;

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



    /**
     * 递归删除文件下所有文件夹及文件
     *
     * @param file
     * @return
     */
    static void deleteALlFile(File file) {

        if (!file.exists())
            throw new RuntimeException("文件不存在!");
        if (file.isFile() || file.isDirectory() && file.listFiles().length==0)
            System.out.println("删除文件:" + file + (file.delete() ? "\t成功" : "失败"));
        else {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isFile())
                    System.out.println("删除文件:" + file1 + (file1.delete() ? "\t成功" : "失败"));
                else if (file1.listFiles().length!=0)
                    deleteALlFile(file1);
                else
                    deleteALlFile(file1.getParentFile());
            }
        }

    }


}