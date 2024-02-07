package org.maxwell.lg.persistence.sqlSession;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 21:44
 */
public interface SqlSession {

    //查询所有
    <E> List<E> selectList(String statementId, Object... params) throws SQLException;

    <T> T selectOne(String statementId, Object... params);

    <T> T getMapper(Class<?> clazz);

}
