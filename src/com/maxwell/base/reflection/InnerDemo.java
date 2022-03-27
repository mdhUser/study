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
        Class<Out> outClass = Out.class;
        Field oid = outClass.getDeclaredField("id");
        oid.setAccessible(true);
        oid.set(out,"maxwell");
        System.out.println(out.getId());
    }

}

class Out {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
