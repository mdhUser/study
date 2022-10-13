package org.maxwell.se.base.jdbc;

import java.sql.*;

/**
 * @description: jdbc特性
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/13 10:52
 */
public class JdbcSpecial {

    static int arm;

    public static void id(int index, String sql) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC", "root", "root"); PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); Statement statement = connection.createStatement();) {
            arm = index;
            ps.setInt(1, arm - 1);
            ResultSet resultSet = ps.executeQuery();
            if (!resultSet.next()) id(arm - 1, sql);
            statement.execute("delete from hero where id=" + (arm - 1));
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {

        String sql = "insert into hero values (null,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC", "root", "root"); PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); Statement statement = connection.createStatement();) {
            ps.setString(1, "历飞雨");
            ps.setDouble(2, 453.1);
            ps.setDouble(3, 340);
            ps.setLong(4, 1000);
            ps.setDouble(5, 45.58);
            ps.execute();

            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println(id);
                String select = "select * from hero where id=?";
                id(id, select);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}