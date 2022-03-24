package com.maxwell.base.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/24 12:08
 */
public class JDBCUtil {


    private static String url;
    private static String username;
    private static String password;


    static {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        url=bundle.getString("url");
        username= bundle.getString("username");
        password=bundle.getString("password");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
