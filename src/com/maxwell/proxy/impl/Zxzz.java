package com.maxwell.proxy.impl;

import com.maxwell.proxy.inter.Singer;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 9:03
 */
public class Zxzz implements Singer {
    @Override
    public void sing(double money) {
        System.out.println("左小诅咒唱歌收钱:"+money);
    }

    @Override
    public void dance(double money) {
        System.out.println("左小诅咒跳舞收钱:"+money);
    }

    public void ttt(){
        System.out.println("this is ttt");
    }

}
