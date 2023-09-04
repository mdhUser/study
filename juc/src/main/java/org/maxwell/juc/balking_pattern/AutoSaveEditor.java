package org.maxwell.juc.balking_pattern;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/26 20:51
 */
public class AutoSaveEditor {

    //文件是否被修改过
    boolean isEdit = false;

    //定时任务线程池
    private ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();

    void startAutoSave() {
        ses.scheduleWithFixedDelay(
                this::save,
                5, 5,
                TimeUnit.SECONDS
        );
    }

    void save() {
        synchronized (this) {
            if (!isEdit) {
                return;
            }
            isEdit=false;
        }

        saveDesc();
    }

    //保存逻辑
    private void saveDesc() {
    }

    //编辑操作
    void edit() {
        synchronized (this) {
            isEdit = true;
        }
    }


}
