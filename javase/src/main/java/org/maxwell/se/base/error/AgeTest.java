package org.maxwell.se.base.error;

import java.util.Scanner;
import java.util.function.Consumer;

public class AgeTest {

    public static void main(String[] args) {

        System.out.println("请输入年龄：");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        Consumer<Integer> check = (a) -> {
            if (a > 150 || a < 0)
                throw new AgeException("年龄超出正常人类范围！！！");
            else
                System.out.println("年龄为" + a);
        };


        try {
            check.accept(i);
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }

    }


}
