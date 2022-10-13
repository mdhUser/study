package org.maxwell.se.base.inter;

public interface DemoInterface {

    int NUM =1314;

    default void init(){
        System.out.println("this a interface!");
    }


}

class Impl implements DemoInterface{


    @Override
    public void init() {
        System.out.println("fuck U");
    }

    public static void main(String[] args) {

        Impl i = new Impl();
        i.init();



    }



}