package com.maxwell.base.jdbc;

/**
 * @description: crud
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/12 19:53
 */
public class TestJdbcCrud {

    public static void main(String[] args) {

        String sql = "delete from hero where id=13";
        String sql2="insert into hero (name,hp,armor,move_speed,damage) values('hero',100.25,45,2,100)";

        System.out.println(JdbcCRUD.crud(sql2));

    }

}