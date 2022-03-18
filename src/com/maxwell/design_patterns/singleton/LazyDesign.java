package com.maxwell.design_patterns.singleton;

/**
 * @description:单例模式-懒汉
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 16:34
 */
public class LazyDesign {

    private LazyDesign() {

    }

    private static LazyDesign instance;

    //TODO 需要调用的时候创建对象返回
    public synchronized static LazyDesign getInstance() {
        if (instance == null)
            instance = new LazyDesign();
        return instance;
    }


}
