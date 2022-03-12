package com.maxwell.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: crud
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/12 20:08
 */
public class JdbcCRUD {

    public static int crud(String sql){
       String title = sql.substring(0,6);
        if ("update".equalsIgnoreCase(title)){
           try(
                   var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
                   ,"root","root");
                   var statement = connection.createStatement();
                   ) {

               statement.execute(sql);
               return 1;
           } catch (SQLException e) {
               e.printStackTrace();
           }
        }

        if ("insert".equalsIgnoreCase(title)){
            try(
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
                            ,"root","root");
                    Statement statement = connection.createStatement();
            ) {
                statement.execute(sql);
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ("delete".equalsIgnoreCase(title)){
            try(
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
                            ,"root","root");
                    Statement statement = connection.createStatement();
            ) {
                statement.execute(sql);
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return -1;
    }


}