package org.maxwell.designpatterns.callback.aysnc;

import java.util.concurrent.Callable;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/24 11:09
 */
public class AsyncTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        //操作代码
        return "异步操作结束";
    }
}
