package org.maxwell.se.design_patterns.wrapper;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/17 12:51
 */
public class Test {

    public static void main(String[] args) {

        LiuDeHuaWrapper wrapper = new LiuDeHuaWrapper(new LiuDeHua());
        wrapper.sing();
        wrapper.dance();

    }

}