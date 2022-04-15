package org.maxwell;

/**
 * @description:  模运算
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/7 22:15
 */
public class Mod {


    public static void main(String[] args) {
        System.out.println(mod(1547,12));
    }


    public static void divisor(int a,int b){
        int mod = mod(a, b)
        ,business=a/b;
        System.out.println(business*mod+b);
    }

    public static int mod(int a,int b){
      return a % b;
    }

}
