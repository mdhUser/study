package com.maxwell.design_patterns.factory;

/**
 * @description: 汽车工厂
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 17:21
 */
public class CarFactory {

    public static Car productCar(CarType carType){
        switch (carType){
            case BENCI : return new Benci();
            case FALALI: return new Falali();
            case BAOSHIJIE: return new BaoShiJie();
            default:return null;
        }

    }

    public static void main(String[] args) {

        Car car = productCar(CarType.BENCI);
        car.run();
        Car car1 =productCar(CarType.FALALI);
        car1.run();


    }

}