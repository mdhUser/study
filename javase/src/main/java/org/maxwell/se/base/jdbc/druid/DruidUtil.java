package org.maxwell.se.base.jdbc.druid;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description: 德鲁伊连接池演示
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/24 17:39
 */
public class DruidUtil {


    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(in);
            //dataSource=DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取连接池
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

}
