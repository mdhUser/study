package org.maxwell.se.regex;


/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/7 8:58
 */

public class RegexDemo {


    public void test(){

        String regex="1[34859]\\d{9}";
        String phone="19850866685";

        String regex1="[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
        String email="734570993@qq.com";

        boolean b = phone.matches(regex);
        boolean b1=email.matches(regex1);

        System.out.println(b);
        System.out.println(b1);
    }

}
