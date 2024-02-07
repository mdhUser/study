package org.maxwell.lg.persistence.sqlSession;

import org.maxwell.lg.persistence.config.BoundSql;
import org.maxwell.lg.persistence.pojo.Configuration;
import org.maxwell.lg.persistence.pojo.MappedStatement;
import org.maxwell.lg.persistence.utils.GenericTokenParser;
import org.maxwell.lg.persistence.utils.ParameterMapping;
import org.maxwell.lg.persistence.utils.ParameterMappingTokenHandler;

import javax.sql.DataSource;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/7 18:41
 */
public class SimpleExecutor implements Executor {

    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object... params) {

        try {
            DataSource dataSource = configuration.getDataSource();
            //获取连接
            Connection connection = dataSource.getConnection();
            //获取SQL语句
            String sql = mappedStatement.getSql();

            BoundSql boundSql = getBoundSql(sql);
            //获取PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(boundSql.getParseSql());

            //设置参数
            String parameterType = mappedStatement.getParameterType();
            Class<?> parameterClass = getClassType(parameterType);
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                //获取参数类型
                String content = parameterMapping.getContent();

                Field declaredField = parameterClass.getDeclaredField(content);
                //暴力访问
                declaredField.setAccessible(true);
                Object o = declaredField.get(params[0]);
                //注入参数
                preparedStatement.setObject(i + 1, o);
            }

            //执行SQL，获取结果集
            ResultSet resultSet = preparedStatement.executeQuery();
            String resultType = mappedStatement.getResultType();
            //获取实体类型
            Class<?> resultTypleClass = getClassType(resultType);
            ArrayList<Object> objects = new ArrayList<>();
            //封装结果集
            while (resultSet.next()) {
                //获取实体类型对象
                Object o = resultTypleClass.getConstructor().newInstance();
                ResultSetMetaData metaData = resultSet.getMetaData();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    //字段名
                    String columnName = metaData.getColumnName(i);
                    //字段值
                    Object value = resultSet.getObject(columnName);

                    //使用反射或内省，根据数据库表和实体类的对应关系，完成封装
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultTypleClass);
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    //写入实体对象
                    writeMethod.invoke(o, value);
                }
                //放入结果集
                objects.add(o);
            }
            return (List<E>) objects;
        } catch (SQLException | ClassNotFoundException | NoSuchFieldException | IllegalAccessException |
                 InstantiationException | InvocationTargetException | NoSuchMethodException |
                 IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    private Class<?> getClassType(String parameterType) throws ClassNotFoundException {
        if (parameterType != null && !parameterType.isEmpty()) {
            return Class.forName(parameterType);
        }
        return null;
    }

    /**
     * 解析SQL
     * 将#{}使用？号代替冰注入参数
     *
     * @param sql
     * @return
     */
    private BoundSql getBoundSql(String sql) {
        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("#{", "}", parameterMappingTokenHandler);
        String parseSql = genericTokenParser.parse(sql);
        //参数列表
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        return new BoundSql(parseSql, parameterMappings);
    }
}
