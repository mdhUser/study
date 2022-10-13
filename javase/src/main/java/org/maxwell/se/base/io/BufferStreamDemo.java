package org.maxwell.se.base.io;

import java.io.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/15 17:58
 */
public class BufferStreamDemo {

    public static void main(String[] args) {

        try {
            copy();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void copy() throws IOException {

        long start = System.currentTimeMillis();
        try (FileOutputStream fos = new FileOutputStream("src/com/maxwell/base/gm.mp4");
             FileInputStream fis = new FileInputStream("F:\\Downloads\\IDMDownload\\video\\鬼灭.mp4")) {
            BufferedInputStream bis = new BufferedInputStream(fis);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] data = new byte[1024 * 8];
            int d;
            while ((d = fis.read(data)) != -1) {
                fos.write(data, 0, d);
            }
            bos.close();
            bis.close();

        }
        long end = System.currentTimeMillis();
        System.out.println("time difference =" + (end - start));

    }

}

