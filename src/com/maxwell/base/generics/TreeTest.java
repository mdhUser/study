package com.maxwell.base.generics;

import com.maxwell.base.entity.APHero;

import java.util.Arrays;

/**
 * @description: 測試二叉樹
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 9:54
 */
public class TreeTest {

    public static void main(String[] args) {


        int[] arry={45,58,96,455,5213,12};

        NodeComparable<Integer> node= new NodeComparable<>();
//      node.add((int)45.36);

        Arrays.stream(arry).forEach(a->node.add(a));

         node.values().stream().forEach(n->System.out.print(n+"\t"));

         NodeComparable<APHero> apNode=new NodeComparable<>();

//         只能将实现comparable接口的类作为泛型
//         NodeComparable<ADHero> adNode=new NodeComparable<>();


    }

}