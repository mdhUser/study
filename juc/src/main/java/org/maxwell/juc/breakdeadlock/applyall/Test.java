package org.maxwell.juc.breakdeadlock.applyall;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/12 16:08
 */
public class Test {

    public static void main(String[] args) {

        List<Account> accounts = IntStream.rangeClosed(1, 10).mapToObj(i ->
             new Account(100)
        ).toList();

        ExecutorService threadPool = Executors.newFixedThreadPool(10);


    }


}
