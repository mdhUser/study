package org.maxwell.designpatterns.adapter;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/8 15:04
 */
public class Adaptor extends Adaptee implements ITarget{
    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }

    @Override
    public void f3() {
        super.fc();
    }
}
