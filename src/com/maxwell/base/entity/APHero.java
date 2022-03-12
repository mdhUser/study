package com.maxwell.base.entity;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/18 9:27
 */
public class APHero extends Hero implements Comparable<APHero> {

    private int AP;

    public APHero() {
    }

    public APHero(String name) {
        super(name);
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    @Override
    public int compareTo(APHero o) {
        return 0;
    }

    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }


}
