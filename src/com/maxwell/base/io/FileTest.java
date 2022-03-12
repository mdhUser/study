package com.maxwell.base.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @description: 文件类深入练习
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/12 14:23
 */
public class FileTest {

    public static void main(String[] args) throws IOException {

        File file = new File("G:\\WorkSpace\\study\\src\\com\\maxwell\\base\\example");
        String path ="g:\\WorkSpace\\study\\src\\com\\maxwell\\base";

        System.out.println(file.getPath());
        //绝对路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(file.exists());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());


        File f = new File(path,"temp.txt");
        if (!f.exists())
            System.out.println(f.createNewFile());
        if (f.delete()) {
            System.out.println("删除成功");
        }

        File f1 = new File("d:/LoL/lol.exe");
        System.out.println(f1.getParentFile().exists());
        System.out.println(f1.getParentFile().mkdir());
        if (!f1.exists())
            System.out.println(f1.createNewFile());
        File parent = new File("d:/LOL");
        f1.delete();
        //todo 要想删除目录需先清空包下文件
        System.out.println("删除LOL:"+parent.delete());
        System.out.println("========================");
        File f2 = new File("c:/Windows");
        File[] files = f2.listFiles();//todo 列出所有文件和子目录
//        Arrays.stream(files).forEach(System.out::println);
        File[] files1 = f2.listFiles((dir,name)->name.endsWith(".exe"));
        Arrays.stream(files1).forEach(System.out::println);





    }

}