package org.maxwell.se.base.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/15 11:38
 */
public class FileTestAndFos {

    public static void main(String[] args) throws IOException {

        File file = new File("src/com/maxwell/base/hello.txt");
        System.out.println(file.createNewFile());

        File[] files = new File("src/com/maxwell/base").listFiles();
        Arrays.stream(files).forEach(System.out::println);

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(44);
        fos.write(45);
        fos.write(46);
        fos.write('A');
        fos.write('B');
        fos.write('C');
        fos.write('\r');
        fos.write("日".getBytes(StandardCharsets.UTF_8));
        fos.close();

        //TODO 输出指定长度
        fos = new FileOutputStream(file, true);
        byte[] bytes = {97, 98, 99, 100, 101};
        fos.write(bytes, 3, 2);
        fos.close();

    }

}

class FisDemo {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/com/maxwell/base/file.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }
        fis.close();

        fis = new FileInputStream("D:\\lz\\图片\\地铁少女.jpg");
        FileOutputStream fos = new FileOutputStream("src/com/maxwell/base/地铁少女.jpg");
        byte[] data = new byte[1024000];
        int d;
        while ((d = fis.read(data)) != -1) {
            fos.write(data,0,d);
        }

        fos.close();
        fis.close();

    }

}