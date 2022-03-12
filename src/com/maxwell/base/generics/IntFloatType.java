package com.maxwell.base.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 泛型练习
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/15 9:58
 */
public class IntFloatType<Letter> {

    private List<Letter> letters = new ArrayList<>();

    public void add(Letter l) {
        letters.add(l);
    }

    public void addAll(List<Letter> l) {
        letters.addAll(l);
    }

    public List<Letter> get() {
        return letters;
    }


    public static void main(String[] args) {


        IntFloatType<Integer> integerType = new IntFloatType<>();
        IntFloatType<Float> floatType = new IntFloatType<>();

        integerType.add(1);
        System.out.println("integerType = " + integerType.get().toString());
        floatType.add(52.45f);
        System.out.println("floatType = " + floatType.get().toString());

    }


}