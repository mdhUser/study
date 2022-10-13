package org.maxwell.se.base.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("周瑜", "小乔");
        map.put("孙策", "大乔");
        map.put("刘备", "孙尚香");
        map.put("诸葛亮", "黄月英");

        System.out.println(map);

        //todo 法一
        Set<String> keys = map.keySet();
        keys.forEach(k -> System.out.println("key=" + k + "," + "value=" + map.get(k)));
        System.out.println("===================");
        //todo 法二
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        entrySet.forEach(e -> System.out.println("key=" + e.getKey() + "," + "value=" + e.getValue()));

    }

}
