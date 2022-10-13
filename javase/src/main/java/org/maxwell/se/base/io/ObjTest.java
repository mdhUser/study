package org.maxwell.se.base.io;

import org.maxwell.se.base.entity.Hero;

import java.io.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/19 14:45
 */
public class ObjTest {

    public static void main(String[] args) {


        Hero[] heroes = new Hero[10];
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].name="hero " + i;
            heroes[i].setHp(3.14 * i);
        }

        File p = new File("d:/LoL");
        File f = new File(p, "heroes.lol");
        if (!f.exists())
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        try (
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {

            Hero[] hs = new Hero[(int) f.length()];
            for (Hero h : heroes) {
                oos.writeObject(h);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}