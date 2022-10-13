package org.maxwell.se.base.io;

import java.io.*;

/**
 * @description: 字符流操作
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/19 11:35
 */
public class CharStream {

    public static void main(String[] args) {
        File file = new File("d:/LoL/lol2.txt");


        try (FileWriter fw = new FileWriter(file)) {

            char[] data = {'你','好'};
            fw.write(data);

        } catch (IOException e) {
            e.printStackTrace();
        }


        //字符流读取
        try (FileReader fr = new FileReader(file)) {

            char[] all = new char[(int) file.length()];
            fr.read(all);
            for (char c : all) {
                System.out.println(c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}