package com.maxwell.base.annotation;

import java.lang.annotation.*;

/**
 * @description: 查找文件
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 16:16
 */
public class FindFiles {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(FileTypes.class)
    public @interface FileType {
        String value();
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FileTypes {
        FileType[] value();
    }


    @FileType(".java")
    @FileType(".xml")
    @FileType(".html")
    @FileType(".go")
    public void work() {

        try {
            FileType[] fileTypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
            System.out.println("将从如下后缀名的文件中查找文件内容");
            for (FileType fileType : fileTypes) {
                System.out.println(fileType.value());
            }
            System.out.println("查找过程略。。。");
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FindFiles().work();
    }
}