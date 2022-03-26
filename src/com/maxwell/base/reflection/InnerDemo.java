package com.maxwell.base.reflection;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/26 22:33
 */
public class InnerDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Out out = new Out();
        out.id="hmx";
        Class<Out> outClass = Out.class;
        Field oid = outClass.getDeclaredField("id");
        String o = (String) oid.get(out);
        System.out.println(o);
    }

    /**
     * @description:
     * @author: Maxwell
     * @email: maodihui@foxmail.com
     * @date: 2022/3/26 22:49
     */

}
class Out {
     String id;
}
