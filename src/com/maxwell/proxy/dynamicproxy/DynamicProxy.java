package com.maxwell.proxy.dynamicproxy;

import com.maxwell.proxy.inter.Singer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 9:35
 */
public class DynamicProxy {

    private final Singer target;

    public DynamicProxy(Singer target) {
        this.target = target;
    }

    public Singer getProxy() {
        Singer singer;
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = new Class[]{Singer.class};
        InvocationHandler h = (Object proxy, Method method, Object[] args) -> {
            String methodName = method.getName();
            System.out.println("execute method:" + methodName);
            Object result = null;
            try {
                result = method.invoke(target, args);
            } catch (IllegalAccessException  | InvocationTargetException | IllegalArgumentException e) {
                e.printStackTrace();
            }
            System.out.println("[after] execute method: " + methodName + ", return value: " + result);
            return result;
        };

        singer = (Singer) Proxy.newProxyInstance(loader, interfaces, h);
        return singer;
    }


}
