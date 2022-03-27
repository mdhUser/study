package com.maxwell.proxy.impl;

import com.maxwell.proxy.inter.Singer;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 10:40
 */
public class Lz implements Singer {
    @Override
    public void sing(double money) {
        System.out.println("李志收钱："+money);
    }

    @Override
    public void dance(double money) {
        System.out.println("李志太污："+money);
    }
}
