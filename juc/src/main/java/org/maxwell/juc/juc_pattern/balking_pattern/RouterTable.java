package org.maxwell.juc.juc_pattern.balking_pattern;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * 在 RPC 框架中，本地路由表是要和注册中心进行信息同步的，
 * 应用启动的时候，会将应用依赖服务的路由表从注册中心同步到本地路由表中，
 * 如果应用重启的时候注册中心宕机，那么会导致该应用依赖的服务均不可用，因为找不到依赖服务的路由表。
 * 为了防止这种极端情况出现，RPC 框架可以将本地路由表自动保存到本地文件中，如果重启的时候注册中心宕机，
 * 那么就从本地文件中恢复重启前的路由表。这其实也是一种降级的方案。
 */
public class RouterTable {

    /**
     * 路由类
     */
    static class Router {
        String iface;
    }

    //Key:接口名
    //Value:路由集合
    ConcurrentHashMap<String, CopyOnWriteArraySet<Router>>
            rt = new ConcurrentHashMap<>();
    //路由表是否发生变化
    volatile boolean changed;

    //将路由表写入本地文件的线程池
    ScheduledExecutorService ses =
            Executors.newSingleThreadScheduledExecutor();

    //启动定时任务
    //将变更后的路由表写入本地文件
    public void startLocalSaver() {
        ses.scheduleWithFixedDelay(this::autoSave, 1, 1, MINUTES);
    }

    //保存路由表到本地文件
    void autoSave() {
        if (!changed) {
            return;
        }
        changed = false;

        this.save2Local();
    }

    /**
     * 将路由表写入本地文件
     * 省略其方法实现
     */
    private void save2Local() {

    }

    //删除路由
    public void remove(Router router) {
        Set<Router> set = rt.get(router.iface);
        if (set != null) {
            set.remove(router);
            //路由表已发生变化
            changed = true;
        }
    }

    //增加路由
    public void add(Router router) {
        Set<Router> set = rt.computeIfAbsent(
                router.iface, r ->
                        new CopyOnWriteArraySet<>());
        set.add(router);
        //路由表已发生变化
        changed = true;
    }

}