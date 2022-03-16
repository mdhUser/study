package com.maxwell.base.recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @description: 文件递归操作
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/15 20:27
 */
public class FileRecursion {

    private static List files;


    public static void main(String[] args) {


    }

    /**
     * 递归查找所以文件
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static void selectAll(File file) throws FileNotFoundException {

        File[] list = file.listFiles();
//        files=Arrays.copyOfRange();
        for (File f : list) {
            if (f.isDirectory())
                selectAll(f);
        }

    }


}
