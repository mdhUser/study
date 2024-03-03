package test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.maxwell.mybatis.entity.User;
import org.maxwell.mybatis.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/9 14:28
 */

public class Test {


    private SqlSession sqlSession;

    @Before
    public void beforeAll() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @org.junit.Test
    public void test1() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        all.forEach(System.out::println);
    }


    @org.junit.Test
    public void testDel() throws IOException {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.deleteById(2));
        sqlSession.commit();
    }


}
