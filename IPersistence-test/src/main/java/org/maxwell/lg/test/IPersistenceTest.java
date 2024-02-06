package org.maxwell.lg.test;

import org.dom4j.DocumentException;
import org.maxwell.lg.persistence.io.Resources;
import org.maxwell.lg.persistence.sqlSession.SqlSessionFactory;
import org.maxwell.lg.persistence.sqlSession.SqlSessionFactoryBuilder;

import java.beans.PropertyVetoException;
import java.io.InputStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 20:50
 */
public class IPersistenceTest {

    public static void main(String[] args) throws PropertyVetoException, DocumentException {
        InputStream resourcesStream = Resources.getResourcesStream("MapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourcesStream);



    }


}
