package com.maxwell.base.io;

import com.maxwell.base.entity.Hero;

import java.io.*;

/**
 * @description: 对象流操作
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/19 14:09
 */
public class ObjectStream {

    public static void main(String[] args) {

        Hero h = new Hero();
        h.name = "garen";
        h.setHp(154);

        //todo 创建文件
        File parent = new File("d:/LoL");
        File file = new File(parent, "garen.lol");
        try {
            if (!file.exists()) file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //创建对象输出流
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);
             //创建对象输入流
             FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {

            oos.writeObject(h);
            Hero hero = (Hero) ois.readObject();

            System.out.println(hero.getName());
            System.out.println(hero.getHp());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}