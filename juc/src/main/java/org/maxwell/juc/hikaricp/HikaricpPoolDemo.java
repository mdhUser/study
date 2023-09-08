package org.maxwell.juc.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Properties;


/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/8 14:36
 */
public class HikaricpPoolDemo {

    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setMinimumIdle(1);
        hikariConfig.setMaximumPoolSize(2);
        hikariConfig.setConnectionTestQuery("select 1");
        hikariConfig.setDataSourceClassName("com.mysql.cj.jdbc.MysqlDataSource");
        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:mysql://localhost:3306/jpa?connectTimeout=5000&characterEncoding=UTF-8&useSSL=false&rewriteBatchedStatements=true");
        hikariConfig.setDataSourceProperties(properties);
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("Maxwell0326");

        //获取数据源
        DataSource dataSource = new HikariDataSource(hikariConfig);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = dataSource.getConnection();

            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("select * from cst_customer");
            
            while (resultSet.next()){
                String name = resultSet.getString(2);
                System.out.println(name);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(resultSet);
            close(statement);
            close(connection);
        }


    }

    private static void close(AutoCloseable closeable) {
        if (Objects.nonNull(closeable)){
            try {
                closeable.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


}
