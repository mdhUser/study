package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/18 13:39
 */
public class HashCodeTest {


    @Test
    public void testCollisionRate() {

        System.out.println(10%3);

        System.out.println(10&3);


    }


    @Test
    public void testHashmap() {
        List<String> list = new ArrayList<>();
        list.add("jlkk");
        list.add("lopi");
        list.add("jmdw");
        list.add("e4we");
        list.add("io98");
        list.add("nmhg");
        list.add("vfg6");
        list.add("gfrt");
        list.add("alpo");
        list.add("vfbh");
        list.add("bnhj");
        list.add("zuio");
        list.add("iu8e");
        list.add("yhjk");
        list.add("plop");
        list.add("dd0p");
        for (String key : list) {
            int hash = key.hashCode() ^ (key.hashCode() >>> 16);
            System.out.println("字符串：" + key + " \tIdx(16)：" + ((16 - 1) & hash) + " \tBit 值："
                    + Integer.toBinaryString(hash) + " - " + Integer.toBinaryString(hash & 16)
                    +"\t\tIdx(32): " + Integer.toBinaryString(key.hashCode()) +" "+
                            Integer.toBinaryString(hash) + " " + Integer.toBinaryString((32 - 1) & hash)
            );
        }
    }

}
