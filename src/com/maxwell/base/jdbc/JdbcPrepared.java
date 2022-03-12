package com.maxwell.base.jdbc;

import java.sql.*;

/**
 * @description: 使用jdbc预编译
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/13 9:08
 */
public class JdbcPrepared {

    public static void main(String[] args) {
        String sql = "insert into hero values (null,?,?,?,?,?)";
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
//                        , "root", "root");
////                Statement statement = connection.createStatement();
//                PreparedStatement ps = connection.prepareStatement(sql);
//        ) {
//            ps.setString(1, "moke");
//            ps.setDouble(2, 456.564);
//            ps.setDouble(3, 144);
//            ps.setLong(4, 434);
//            ps.setDouble(5, 40);
//            ps.execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
                        , "root", "root");
                PreparedStatement ps = connection.prepareStatement(sql);
                Statement statement = connection.createStatement();
        ) {
           long start = System.currentTimeMillis();
            for (int i=0;i<10000;i++){
                ps.setString(1, "韩立"+i);
                ps.setDouble(2, 456.564);
                ps.setDouble(3, 144);
                ps.setLong(4, 434);
                ps.setDouble(5, 400);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            long time = end-start;

            long start2 =System.currentTimeMillis();
            for (int i=0;i<10000;i++) {
                String sql2 = "insert into hero values(null," + "'历飞雨"+i+"'" + "," + 100.25 + "," + 45 + "," + 25 + "," + 100 + ")";
                statement.execute(sql2);
            }
            long end2 = System.currentTimeMillis();
            long time2=end2-start2;

            System.out.println("预编译处理："+time+"\t"+"statement:"+time2);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
