package com.maxwell.base.other;

public class TestArray {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};
        Int.doInt(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

        int a =100;
        Int.doNum(a);
        System.out.println(a);
    }

}

class Int {

    static void doNum(int a){
        int b=a;
        b=10;
    }


    static void doInt(int[] a) {
        int[] z = a;
        //todo 此时引用指针指向数组a地址故可以更改数值
        z[0] = 99;
    }

}