package com.maxwell.base.jdbc.demo;

import com.maxwell.base.jdbc.druid.DruidUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/24 17:48
 */
public class DruidDemo {

    public static void main(String[] args) throws SQLException {

        DataSource ds = DruidUtil.getDataSource();

        /**
         * 测试连接池
         */
        for (int i = 0; i < 11; i++) {
            Connection connection = ds.getConnection();
            System.out.println("connection = " + connection);
            if (i==5)
                connection.close();
        }


    }


}
