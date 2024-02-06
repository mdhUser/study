package org.maxwell.lg.persistence.sqlSession;

import org.dom4j.DocumentException;
import org.maxwell.lg.persistence.config.XMLConfigBuilder;
import org.maxwell.lg.persistence.pojo.Configuration;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 20:24
 */
public class SqlSessionFactoryBuilder {


    public SqlSessionFactory build(InputStream in) throws PropertyVetoException, DocumentException {

        //1.使用dom4j解析配置文件，将解析出来的内容封装到Configuration
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(in);

        //2.创建sqlSessionFactory 来生产sqlSession会话
        DefaultSqlSessionFactory defaultSqlSessionFactory = new DefaultSqlSessionFactory(configuration);

        return defaultSqlSessionFactory;
    }

}
