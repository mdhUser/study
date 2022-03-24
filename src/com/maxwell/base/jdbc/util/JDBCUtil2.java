package com.maxwell.base.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/24 13:15
 */
public class JDBCUtil2 {

    private static String url;
    private static String username;
    private static String password;

    static {

        InputStream in = JDBCUtil2.class.getClassLoader().getResourceAsStream("database.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
           url= properties.getProperty("url");
           username=properties.getProperty("username");
           password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

}
