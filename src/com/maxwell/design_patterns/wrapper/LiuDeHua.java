package com.maxwell.design_patterns.wrapper;

/**
 * @description: 被装饰类
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/17 12:02
 */
public class LiuDeHua implements Star{
    @Override
    public void sing() {
        System.out.println("天王唱歌");
    }

    @Override
    public void dance() {
        System.out.println("天王跳舞");
    }
}
