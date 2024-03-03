package org.maxwell.mybatis.plugin;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/12 19:11
 */
@Intercepts({
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
})
public class MyPlugin implements Interceptor {


    /**
     * 拦截目标对象的目标方法每次执行都会触发intercept
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("started ...");
        return invocation.proceed();
    }

    /**
     * 生成当前代理对象放入拦截器链中
     *
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        System.out.println("将要包装的⽬标对象：" + target);
        return Plugin.wrap(target, this);
    }

    /**
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("获取到配置文件的参数：" + properties);
    }
}
