package org.maxwell.se.base.jdbc.demo;

import org.maxwell.se.base.jdbc.util.JDBCUtil2;

import java.sql.SQLException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/24 12:54
 */
public class JdbcDemo {


    public static void main(String[] args) {

        try (var connection = JDBCUtil2.getConnection();
             var statement = connection.createStatement()
        ) {

            connection.setAutoCommit(false);
            int i = statement.executeUpdate("delete from user where id=4");
            if (i > 0)
                connection.commit();
            else connection.rollback();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}
