package com.maxwell.base.io;

import java.io.*;
import java.util.Arrays;

/**
 * @description: 拆分文件
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/19 9:49
 */
public class SplitFile {

    public static void main(String[] args) {

        File file = new File("D:\\heimaHomeWork\\FeiQ.exe");

        try (FileInputStream fis = new FileInputStream(file)) {

            //先读取文件字节数
            byte[] content = new byte[(int) file.length()];
            fis.read(content);
            //判断计算文件数量
            int eachSize = 100 * 1024;
            int count = content.length;
            int fileCount;
            if (count % eachSize == 0) fileCount = count / eachSize;
            else fileCount = count / eachSize + 1;

            for (int i = 0; i < fileCount; i++) {
                //创建文件
                String name = file.getName() + "-" + i;
                File eachFile = new File(file.getParent(), name);
                byte[] eachContent;

                // 从源文件的内容里，复制部分数据到子文件
                // 除开最后一个文件，其他文件大小都是100k
                // 最后一个文件的大小是剩余的
                if (i != fileCount - 1) // 不是最后一个
                    eachContent = Arrays.copyOfRange(content, eachSize * i, eachSize * (i + 1));
                else // 最后一个
                    eachContent = Arrays.copyOfRange(content, eachSize * i, content.length);

                try (FileOutputStream fos = new FileOutputStream(eachFile)) {
                    fos.write(eachContent);
                    System.out.printf("输出子文件%s,其大小是%d字节%n", eachFile.getAbsolutePath(), eachFile.length());

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}