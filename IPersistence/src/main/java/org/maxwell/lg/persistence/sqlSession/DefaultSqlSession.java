package org.maxwell.lg.persistence.sqlSession;

import org.maxwell.lg.persistence.pojo.Configuration;
import org.maxwell.lg.persistence.pojo.MappedStatement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 21:45
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> List<E> selectList(String statementId, Object... params) {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        MappedStatement mappedStatement = configuration.getMappedStatementMap().get(statementId);
        List<Object> list = null;
        try {
            list = simpleExecutor.query(configuration, mappedStatement, params);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return (List<E>) list;
    }


    @Override
    public <T> T selectOne(String statementId, Object... params) {
        List<Object> list = selectList(statementId, params);
        if (Objects.isNull(list) || list.isEmpty())
            return null;
        return (T) list.remove(0);
    }


    @Override
    public <T> T getMapper(Class<?> clazz) {
        //使用JDK动态代理生成代理对象
        Object o = Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{clazz}, (InvocationHandler) (proxy, method, args) -> {
            //方法名
            String methodName = method.getName();
            //全限定类名
            String className = method.getDeclaringClass().getName();

            //找到方法id
            String statementId = className.concat(".").concat(methodName);

            //获取被调方法返回值类型
            Type genericReturnType = method.getGenericReturnType();
            //是否进行泛型类型参数化 true=collection
            if (genericReturnType instanceof ParameterizedType) {
                return selectList(statementId, args);
            }
            return selectOne(statementId, args);
        });
        return (T) o;
    }


}
