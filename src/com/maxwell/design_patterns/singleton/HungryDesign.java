package com.maxwell.design_patterns.singleton;

/**
 * @description:单例模式-饿汉
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/17 20:38
 */
public class HungryDesign {

    //todo 构造方法私有化
    private HungryDesign() {

    }

    private static final HungryDesign instance = new HungryDesign();

    public static HungryDesign getInstance() {
        return instance;
    }
}
