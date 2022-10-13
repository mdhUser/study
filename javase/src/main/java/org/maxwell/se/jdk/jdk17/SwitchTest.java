package org.maxwell.se.jdk.jdk17;

import java.util.Scanner;

/**
 * @description:  switch 新特性
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/15 11:41
 */
public class SwitchTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入星期：");
            switch (in.nextInt()){
                case 1,2,3,4,5 ->
                    System.out.println("工作日");
                case 6,7 ->
                    System.out.println("休息日");
            }
        }


    }



}
