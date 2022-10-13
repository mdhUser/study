package org.maxwell.se.base.io;

import java.io.*;

/**
 * @description: IO流操作
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/19 9:25
 */
public class StreamTest {

    public static void main(String[] args) {


        //输出流
        File fo = new File("d:/LoL/lol2.txt");

        byte[] data = {88, 89};

        try (FileOutputStream fos = new FileOutputStream(fo)) {
            fos.write(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //输入流
        File fi = new File("d:/LoL/lol.txt");

        try (
                FileInputStream fis = new FileInputStream(fi);
        ) {
            File file = new File("d:/LoL");
            File file1 = new File(file, "lol.txt");
            if (!file.exists())
                file.mkdir();
            if (!file1.exists())
                file1.createNewFile();

            byte[] all = new byte[(int) fi.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
