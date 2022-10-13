package org.maxwell.se.base.entity;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 9:27
 */

public class  ADHero extends Hero {

    private int AD;

    public ADHero() {
    }

    public ADHero(String name) {
        super(name);
    }

    public int getAD() {
        return AD;
    }

    public void setAD(int AD) {
        this.AD = AD;
    }

    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
}
