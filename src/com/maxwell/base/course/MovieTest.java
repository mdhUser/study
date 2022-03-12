package com.maxwell.base.course;

import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/24 17:36
 */
public class MovieTest {


    public static void main(String[] args) {

        List<Movie> list = Arrays.asList(new Movie("唐山大地震", "冯小刚", "灾难"),
                new Movie("羞羞的铁拳", "宋阳", "喜剧"),
                new Movie("集结号", "冯小刚", "历史"));

        list.stream().filter(l -> "冯小刚".equals(l.getDirector())).forEach(System.out::println);
    }
}