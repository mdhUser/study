package org.maxwell.se.base.jdbc;

import java.sql.*;

/**
 * @description: 查询
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/12 20:41
 */
public class JdbcQuery {

    public static void main(String[] args) {

        //todo ResultSet实现查询
//        try ( Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
//                "root", "root");
//              Statement statement = connection.createStatement()){
//
//
//            ResultSet resultSet = statement.executeQuery("select * from hero");
//            while (resultSet.next()){
//                int id=resultSet.getInt(1);
//                String name=resultSet.getString(2);
//                double hp = resultSet.getDouble(3);
//                double armor =resultSet.getDouble(4);
//                long moveSpeed = resultSet.getLong(5);
//                double damage = resultSet.getDouble(6);
//                System.out.println(id+"\t"+name+"\t"+hp+"\t"+armor+"\t"+moveSpeed+"\t"+damage);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //todo 判断登录
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
//                "root", "root");
//             Statement statement = connection.createStatement()) {
//
//            String name="maxwell";
//            String password="maodihui123";
//            ResultSet resultSet = statement.executeQuery("select * from user where name='"+name+"' and pwd='"+password+"'");
//
//            if (resultSet.next())
//                System.out.println("登录成功！");
//            else
//                System.out.println("账号密码错误!");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //todo  总数计算
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC", "root", "root"); Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from hero");
            int total = 0;
            while (resultSet.next()) {
                total++;
            }
            System.out.println("总数为" + total);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
