package com.maxwell.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: jdbc 事务
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/13 17:28
 */
public class JdbcTransaction {

    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection
                             ("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC", "root", "root");
             Statement statement = connection.createStatement();) {


            connection.setAutoCommit(false);

            //加血的SQL
            String sql1 = "update hero set hp = hp +1 where id = 22";
            statement.execute(sql1);

            //减血的SQL
            //不小心写错写成了 updata(而非update)
            String sql2 = "updata hero set hp = hp -1 where id = 22";
            statement.execute(sql2);

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}