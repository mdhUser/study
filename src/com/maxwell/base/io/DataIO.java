package com.maxwell.base.io;

import java.io.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 16:33
 */
public class DataIO {

    public static void main(String[] args) {


        File file = new File("d:/LOL");
        File file1 = new File(file, "lol.txt");
        if (!file1.getParentFile().exists())
            file.mkdir();
        else if (!file1.exists())
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        //todo 写入数据流
        try (FileOutputStream fos = new FileOutputStream(file1);
             DataOutputStream dos = new DataOutputStream(fos)
        ) {

            dos.writeBoolean(true);
            dos.writeUTF("你永远是我的宝贝");
            dos.writeChar('A');
            dos.writeInt(123);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //todo 读取数据流
        try (FileInputStream fis = new FileInputStream(file1);
             DataInputStream dis = new DataInputStream(fis)) {

            boolean flag = dis.readBoolean();
            String str = dis.readUTF();
            char c = dis.readChar();
            int i = dis.readInt();

            System.out.println("i = " + i);
            System.out.println("c = " + c);
            System.out.println("str = " + str);
            System.out.println("flag = " + flag);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
