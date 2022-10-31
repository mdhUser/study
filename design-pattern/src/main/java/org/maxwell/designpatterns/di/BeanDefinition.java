package org.maxwell.designpatterns.di;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/10/31 16:22
 */
@Getter
@Setter
public class BeanDefinition {

    private String id;
    private String className;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private Scope scope = Scope.SINGLETON;
    private boolean lazyInit = false;

    // 省略必要的getter/setter/constructors
    public boolean isSingleton() {
        return scope.equals(Scope.SINGLETON);
    }

    public enum Scope {
        SINGLETON,
        PROTOTYPE
    }

    @Setter
    @Getter
    public static class ConstructorArg {
        private boolean isRef;
        private Class<?> type;
        private Object arg;
    }

}
