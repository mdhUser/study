package com.maxwell.proxy.staticproxy;

import com.maxwell.proxy.inter.Singer;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 9:24
 */
public class StaticProxy implements com.maxwell.proxy.inter.Singer {

    private Singer singer;

    public StaticProxy(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing(double money) {
        System.out.println("唱新歌~~");
        singer.sing(money);
        System.out.println("复盘~~");
    }

    @Override
    public void dance(double money) {
        System.out.println("跳新舞~~");
        singer.dance(money);
        System.out.println("复盘~~");
    }
}
