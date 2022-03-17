package com.maxwell.base.recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 文件递归操作
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/15 20:27
 */
public class FileRecursion {


    public static void main(String[] args) {

//        deleteALlFile(new File("F:\\昔日摄影\\五、风光修图技法"));

        try {
            System.out.println(selectAllFile(new File("F:\\昔日摄影\\101CANON")).size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 递归查找所有文件
     *
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static List<File> selectAllFile(File file) throws FileNotFoundException {
        List<File> fileList = new ArrayList<>();
        if (file.isFile()) {
            fileList.add(file);
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory())
                    fileList.addAll(selectAllFile(f));
                else
                    fileList.add(f);
            }
        }
        return fileList;

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
        if (file.isFile())
            System.out.println("删除文件:" + file + (file.delete() ? "\t成功" : "\t失败"));
        else {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile())
                    System.out.println("删除文件:" + f + (f.delete() ? "\t成功" : "\t失败"));
                else
                    deleteALlFile(f);
            }
            System.out.println("删除文件:" + file + (file.delete() ? "\t成功" : "\t失败"));
        }

    }


}