package org.maxwell.lg.persistence.sqlSession;

import org.maxwell.lg.persistence.pojo.Configuration;
import org.maxwell.lg.persistence.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/7 18:40
 */
public interface Executor {

    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement,Object... params) throws SQLException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IntrospectionException, NoSuchMethodException, InvocationTargetException, InstantiationException;

}
