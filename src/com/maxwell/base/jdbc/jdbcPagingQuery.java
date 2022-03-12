package com.maxwell.base.jdbc;

import com.maxwell.base.entity.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 分页查询
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/12 21:12
 */
public class jdbcPagingQuery {


    public static void pagingQuery(int start, int count) {

        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC", "root", "root");
             Statement statement = connection.createStatement()) {

            List<Hero> heroList = new ArrayList<>();
            statement.execute("select * from hero");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Hero hero = new Hero();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double hp = resultSet.getDouble(3);
                double armor = resultSet.getDouble(4);
                long moveSpeed = resultSet.getLong(5);
                double damage = resultSet.getDouble(6);
                hero.setId(id);
                hero.setArmor(armor);
                hero.setDamage(damage);
                hero.setName(name);
                hero.setHp(hp);
                hero.setMoveSpeed(moveSpeed);
                heroList.add(hero);
            }

            List<Hero> list = heroList.stream().skip(start).limit(count).collect(Collectors.toList());
            list.stream().forEach(l -> System.out.println(l.toString()));


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        pagingQuery(10, 5);
    }

}
