package com.maxwell.base.thread.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 消费者
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/13 15:36
 */
public class Desk {

    public static final List<String> DISH = new ArrayList<>();

    public static void main(String[] args) {

        new Thread(new Cooker()).start();
        new Thread(new Foodie()).start();

    }


}