package org.maxwell.designpatterns.callback.aysnc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/24 11:13
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> submit = executorService.submit(new AsyncTask());

        System.out.println("submit.get() = " + submit.get());

    }

}
