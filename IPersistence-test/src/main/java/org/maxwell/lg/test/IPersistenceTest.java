package org.maxwell.lg.test;

import org.dom4j.DocumentException;
import org.maxwell.lg.dao.UserDao;
import org.maxwell.lg.entity.User;
import org.maxwell.lg.persistence.io.Resources;
import org.maxwell.lg.persistence.sqlSession.SqlSession;
import org.maxwell.lg.persistence.sqlSession.SqlSessionFactory;
import org.maxwell.lg.persistence.sqlSession.SqlSessionFactoryBuilder;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 20:50
 */
public class IPersistenceTest {

    public static void main(String[] args) throws PropertyVetoException, DocumentException, SQLException {
        InputStream resourcesStream = Resources.getResourcesStream("MapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourcesStream);
        //创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
//        User userRes = sqlSession.selectOne("user.selectOne", user);
//        System.out.println(userRes);
//
//        List<Object> list = sqlSession.selectList("user.selectList");
//        list.forEach(System.out::println);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> list = userDao.findAll();
//        list.forEach(System.out::println);

        System.out.println(userDao.findOne(user));

    }


}
