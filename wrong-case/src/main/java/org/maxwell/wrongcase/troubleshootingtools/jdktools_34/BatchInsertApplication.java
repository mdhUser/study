package org.maxwell.wrongcase.troubleshootingtools.jdktools_34;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class BatchInsertApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(BatchInsertApplication.class, args);
    }

    @PostConstruct
    public void init() {
        //初始化表
        jdbcTemplate.execute("drop table IF EXISTS `testuser`;");
        jdbcTemplate.execute("create TABLE `testuser` (\n" +
                "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(255) NOT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;");
    }

    @Override
    public void run(String... args) {

        long begin = System.currentTimeMillis();
        String sql = "INSERT INTO `testuser` (`name`) VALUES (?)";
        //使用JDBC批量更新
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                //第一个参数(索引从1开始)，也就是name列赋值
                preparedStatement.setString(1, "usera" + i);
            }

            @Override
            public int getBatchSize() {
                //批次大小为10000
                return 10000;
            }
        });
        log.info("took : {} ms", System.currentTimeMillis() - begin);
    }
}