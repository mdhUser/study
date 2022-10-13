package org.maxwell.se.base.jdbc.test;

import org.maxwell.se.base.jdbc.JdbcPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: 测试连接池
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/13 21:44
 */
public class TestJdbcPool {


    public static void main(String[] args) {


        JdbcPool jp = new JdbcPool(3);
        for (int i = 0; i < 100; i++) {
            new WorkingThread("线程" + i, jp).start();
        }
    }

}

class WorkingThread extends Thread {
    private JdbcPool jp;

    public WorkingThread(String name, JdbcPool jp) {
        super(name);
        this.jp = jp;
    }

    @Override
    public void run() {
        Connection c = jp.getConnection();
        System.out.println(this.getName() + ":\t 获取了一根连接，并开始工作");
        try (Statement statement = c.createStatement()) {

            statement.execute("select * from hero limit 100");
            Thread.sleep(1000);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jp.returnConnection(c);

    }
}