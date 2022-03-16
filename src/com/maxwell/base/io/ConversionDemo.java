package com.maxwell.base.io;

import java.io.*;

/**
 * @description: 转换流(转换编码)
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/16 17:12
 */
public class ConversionDemo {


    public static void main(String[] args) {
//        write();
        read();
    }

    public static void write() {
        try (
                FileOutputStream fos = new FileOutputStream("src/com/maxwell/base/tq.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK")
        ) {
            osw.write("今天天气真好！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void read() {
        try (
                FileInputStream fos = new FileInputStream("src/com/maxwell/base/hello.txt");
                InputStreamReader isw = new InputStreamReader(fos, "utf-8")
        ) {
            int len;
            while ((len = isw.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}