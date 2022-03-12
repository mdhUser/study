package com.maxwell.base.util;

import com.maxwell.base.annotation.JDBCConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/21 15:41
 */
public class DBUtilChild extends DBUtil {

    public static Connection getConnection2() throws SQLException {

        JDBCConfig config = DBUtilChild.class.getAnnotation(JDBCConfig.class);
        String database = config.database();
        int port = config.port();
        String userName = config.userName();
        String password = config.password();
        String ip = config.ip();
        String encoding = config.encoding();

        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s&useSSL=false&serverTimezone=UTC"
                , ip, port, database, encoding);

        return DriverManager.getConnection(url, userName, password);

    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection2());
    }

}