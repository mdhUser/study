package org.maxwell.se.design_patterns.wrapper;

/**
 * @description: 装饰类
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/17 12:48
 */
public class LiuDeHuaWrapper implements Star {

    private LiuDeHua liuDeHua;

    public LiuDeHuaWrapper(LiuDeHua liuDeHua) {
        this.liuDeHua = liuDeHua;
    }

    @Override
    public void sing() {
        System.out.print("天王唱歌，演唱一曲《忘情水》\n");
    }

    @Override
    public void dance() {
        liuDeHua.dance();
        System.out.print("来一段bad boy\n");
    }
}
