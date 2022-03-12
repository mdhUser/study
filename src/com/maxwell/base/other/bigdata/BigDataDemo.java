package com.maxwell.base.other.bigdata;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * 练习超大大数据运算
 */
public class BigDataDemo {

    public static void main(String[] args) {


        BigInteger bigInteger1 = new BigInteger(String.valueOf(100000000000000L));
        BigInteger bigInteger2 = new BigInteger(String.valueOf(100000000000000L));
        BigInteger bigInteger3 = bigInteger1.multiply(bigInteger2);
        System.out.println(bigInteger3);

        BigDecimal b1 = new BigDecimal(4546.54987);
        BigDecimal b2 = new BigDecimal(3.1415926);
        System.out.println(b1.divide(b2, RoundingMode.HALF_UP));

    }
}