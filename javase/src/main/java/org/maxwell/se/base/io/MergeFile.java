package org.maxwell.se.base.io;

import java.io.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 16:29
 */
public class MergeFile {


    public static void main(String[] args) throws FileNotFoundException {

        try {
            merge();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void merge() throws IOException {
        int count = 0;
        while (true) {
            File file = new File("D:\\heimaHomeWork\\FeiQ.exe-" + count);
            if (!file.exists())
                break;
            count++;
        }

        File[] files = new File[count];
        for (int i = 0; i < files.length; i++) {
            files[i] = new File("D:\\heimaHomeWork\\FeiQ.exe-" + i);
        }

        File file = new File("d:/FeiQ.exe");
        OutputStream fos = new FileOutputStream(file);

        for (int i = 0; i < files.length; i++) {
            FileInputStream fis = new FileInputStream(files[i]);
            try (fis) {
                byte[] readContent = new byte[(int) files[i].length()];
                fos.write(readContent);
                fos.flush();
                System.out.println("写入子文件:" + files[i].length() + "文件名:" + files[i].getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fos.close();

    }
}