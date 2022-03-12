package com.maxwell.base.other;

import java.util.Scanner;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/15 11:41
 */
public class SwitchTest {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("请输入星期：");
        switch (in.nextInt()){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("工作日");
                break;
            case 6:
            case 7:
                System.out.println("休息日");
            break;
        }


    }



}
