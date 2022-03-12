package com.maxwell.base.jdbc;

import java.sql.*;
import java.util.Scanner;

/**
 * @description: dsad
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/13 8:20
 */
public class TestTransactional {

    public static void main(String[] args) {
        String delete = "delete from hero limit ?";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
                        , "root", "root");
                PreparedStatement ps = connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS);
                Statement statement = connection.createStatement();
        ) {

            connection.setAutoCommit(false);


            statement.execute("select id from hero limit 10");
            ResultSet set = statement.getResultSet();

            while (set.next()) {
                System.out.println("删除id=" + set.getInt(1) + "的hero");
            }

            Scanner in = new Scanner(System.in);
            System.out.println("是否删除十条数据？（Y/N）");
            String input= in.next();
            ps.setInt(1, 10);
            ps.execute();
            if ("Y".equalsIgnoreCase(input))
                connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
