package org.maxwell.juc.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/6/2 13:19
 */
public class CFutureDemo {

    public static void main(String[] args) {

        //testSerial();
        //testOr();
        //testException();





    }

    private static void testException() {
        CompletableFuture<Integer> exceptionally = CompletableFuture.supplyAsync(() -> 7 / 0)
                .thenApply(i -> i * 10)
                .exceptionally(e -> 0);

        System.out.println("exceptionally.join() = " + exceptionally.join());
    }

    private static void testOr() {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(5, 10);
            sleep(t, TimeUnit.SECONDS);
            return "f1 complete cost %s seconds".formatted(t);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            int t = getRandom(5, 10);
            sleep(t, TimeUnit.SECONDS);
            return "f2 complete cost %s seconds".formatted(t);
        });
        CompletableFuture<String> or = f1.applyToEither(f2, s -> s);
        System.out.println(or.join());
    }

    private static int getRandom(int s, int e) {
        return ThreadLocalRandom.current().nextInt(s, e + 1);
    }

    static void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
        }
    }

    private static void testSerial() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello World")
                .thenApply(s -> s + " my dad")
                .thenApply(String::toUpperCase);
        System.out.println("result = " + future.join());
    }


}
