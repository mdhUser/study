package org.maxwell.se.base.annotation.myhibernate;

import org.maxwell.se.base.entity.Hero;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/22 15:05
 */
public class ParseHibernateAnnotation {

    public static void main(String[] args) throws NoSuchMethodException {

        Class<Hero> clazz = Hero.class;
        Entity entity = clazz.getAnnotation(Entity.class);
        if (null == entity)
            System.out.println("Hero类不是实体类");
        else {
            System.out.println("Hero 是实体类");
            Table table = clazz.getAnnotation(Table.class);
            String tableName = table.name();
            System.out.println("POJO对应表名：" + tableName);
        }
        Method[] methods = clazz.getMethods();
        Method primaryKeyMethod = null;
        for (Method method : methods) {
            Id id = method.getAnnotation(Id.class);
            if (null != id) {
                primaryKeyMethod = method;
                break;
            }
        }

        if (null != primaryKeyMethod) {
            System.out.println("找到主键Id");
        }


    }
}