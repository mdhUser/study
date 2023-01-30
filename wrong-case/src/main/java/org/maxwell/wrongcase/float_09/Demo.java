package org.maxwell.wrongcase.float_09;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/28 11:03
 */
@Slf4j
public class Demo {

    private static void testScale() {
        BigDecimal bigDecimal1 = new BigDecimal("100");
        BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(100d));
        BigDecimal bigDecimal3 = new BigDecimal(String.valueOf(100));
        BigDecimal bigDecimal4 = BigDecimal.valueOf(100d);
        BigDecimal bigDecimal5 = new BigDecimal(Double.toString(100));

        print(bigDecimal1); //scale 0 precision 3 result 401.500
        print(bigDecimal2); //scale 1 precision 4 result 401.5000
        print(bigDecimal3); //scale 0 precision 3 result 401.500
        print(bigDecimal4); //scale 1 precision 4 result 401.5000
        print(bigDecimal5); //scale 1 precision 4 result 401.5000
    }


    public static void testRoundMode() {

        //字符串格式化默认四舍五入
        double d = 3.35;
        float f = 3.35f;
        System.out.printf("%.1f%n", d);
        System.out.printf("%.1f%n", f);


        BigDecimal bigDecimal = new BigDecimal("3.35");
        //保留一位后舍去
        BigDecimal bigDecimal1 = bigDecimal.setScale(1, RoundingMode.DOWN);
        System.out.println(bigDecimal1);
        //四舍五入
        BigDecimal bigDecimal2 = bigDecimal.setScale(1, RoundingMode.HALF_UP);
        System.out.println(bigDecimal2);

    }


    public static void testBigDecimal() {
        //false
        HashSet<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(new BigDecimal("1.0"));
        System.out.println(hashSet.contains(new BigDecimal("1")));

        //true
        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(new BigDecimal("1.0"));
        System.out.println(treeSet.contains(new BigDecimal("1")));

        //返回true
        Set<BigDecimal> hashSet2 = new HashSet<>();
        hashSet2.add(new BigDecimal("1.0").stripTrailingZeros());
        System.out.println(hashSet2.contains(new BigDecimal("1.000").stripTrailingZeros()));

        System.out.println(new BigDecimal("5").compareTo(new BigDecimal("1")));

    }

    public static void main(String[] args) {
        //testScale();
        //testRoundMode();
        testBigDecimal();

        BigDecimal bigDecimal = BigDecimal.valueOf(4.35);
    }


    private static void print(BigDecimal bigDecimal) {
        log.info("scale {} precision {} result {}", bigDecimal.scale(), bigDecimal.precision(), bigDecimal.multiply(new BigDecimal("4.015")));
    }

}
