package com.maxwell.base.io;

import java.io.File;
import java.io.IOException;

/**
 * @description: 文件类创建文件夹演示理解
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/12 16:58
 */
public class FileMkidr {

    public static void main(String[] args) throws IOException {


        File file = new File("d:/LOL/hero/gran.exe");
        //todo 当父路径即父文件夹存在时才可创建文件夹
//        System.out.println(file.mkdir());
        //todo 用mkdirs创建路径包括父文件夹（）
//        System.out.println(file.mkdirs());
        //todo 删除当前文件或文件夹
//        System.out.println(file.delete());
        //todo 删除父路径
//        System.out.println(file.getParentFile().delete());

        System.out.println(file.getParentFile().mkdirs());
        if (!file.exists())
            System.out.println(file.createNewFile());


    }

}