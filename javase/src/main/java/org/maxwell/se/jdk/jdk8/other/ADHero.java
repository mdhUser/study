package org.maxwell.se.jdk.jdk8.other;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/25 11:15
 */
public class ADHero extends Hero{

    private int ad;

    public int getAd() {
        return ad;
    }

    public void setAd(int ad) {
        this.ad = ad;
    }

    public ADHero(){

    }

    public ADHero(String name) {
        super(name);
    }
}
