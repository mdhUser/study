package com.maxwell.base.util;

import com.maxwell.base.annotation.JDBCConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: jdbc注解工具
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 14:07
 */

@JDBCConfig(ip = "localhost" , userName = "root" , password = "root" , encoding = "UTF-8" , database = "mdh")
@JDBCConfig(ip = "localhost" , userName = "root" , password = "root" , encoding = "UTF-8" , database = "mdh")//@Repeatable可赋值多个注解
public class DBUtil {


    public static Connection getConnection() throws SQLException {
        JDBCConfig config =DBUtil.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        int port = config.port();
        String userName = config.userName();
        String database = config.database();
        String password = config.password();
        String encoding = config.encoding();
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + database + "?" + "characterEncoding=" + encoding + "&useSSL=false&serverTimezone=UTC";
        return DriverManager.getConnection(url, userName, password);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }

}