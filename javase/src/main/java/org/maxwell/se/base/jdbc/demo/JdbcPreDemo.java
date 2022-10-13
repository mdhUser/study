package org.maxwell.se.base.jdbc.demo;

import org.maxwell.se.base.jdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/24 15:54
 */
public class JdbcPreDemo {

    public static void main(String[] args) throws SQLException {

        Connection connection = JDBCUtil.getConnection();
        String sql = "select * from user limit ?";
        try (connection;
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,100);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("username");
                System.out.println("name = " + name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
