package org.maxwell.designpatterns.observer;

import com.google.common.base.Preconditions;
import org.maxwell.designpatterns.annotation.Subscribe;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/15 21:20
 */
public class ObserverRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();


    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        observerActions.forEach((k, v) -> {
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(k);
            if (registeredEventActions == null) {
                registry.putIfAbsent(k, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(k);
            }
            registeredEventActions.addAll(v);
        });
    }


    public List<ObserverAction> getMatchedObserverActions(Object event){
        List<ObserverAction> matchObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            if (postedEventType.isAssignableFrom(eventType)){
                matchObservers.addAll(eventActions);
            }
        }
        return matchObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> evenType = parameterTypes[0];
            if (!observerActions.containsKey(evenType)) {
                observerActions.put(evenType, new ArrayList<>());
            }
            observerActions.get(evenType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters." +
                        "Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }


}