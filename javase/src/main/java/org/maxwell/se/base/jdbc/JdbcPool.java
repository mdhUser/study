package org.maxwell.se.base.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数据库连接池
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/13 21:06
 */
public class JdbcPool {

    List<Connection> connections = new ArrayList<>();

    int size;

    public JdbcPool(int size) {
        this.size = size;
        init();
    }


    public void init() {

        try {
            for (int i = 0; i < size; i++) {
                Connection connection = DriverManager.
                        getConnection("jdbc:mysql://localhost:3306/mdh?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC"
                                , "root", "root");
                connections.add(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public synchronized Connection getConnection() {
        while (connections.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Connection c = connections.remove(0);
        return c;
    }

    public synchronized void returnConnection(Connection c) {
        connections.add(c);
        this.notifyAll();
    }

}
