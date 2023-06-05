package org.maxwell.juc.happens_before;

import java.util.concurrent.*;

/**
 * 美团面试题1
 *
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/10 11:29
 */
public class MeituanAdd {


    static class A {
        static int a;

        static Integer get() {
            a = ThreadLocalRandom.current().nextInt(100) + 1;
            System.out.println("a = " + a);
            return a;
        }
    }

    static class B {
        static int b;

        static Integer get() {
            b = ThreadLocalRandom.current().nextInt(100) + 1;
            System.out.println("b = " + b);
            return b;
        }
    }

    static class C {
        static int c;

        static Integer get() {
            c = ThreadLocalRandom.current().nextInt(100) + 1;
            System.out.println("c = " + c);
            return c;
        }
    }


    class Worker implements Runnable {

        @Override
        public void run() {

        }
    }

    int add() {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread t1 = new Thread(() -> {
            A.get();
            countDownLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            B.get();
            countDownLatch.countDown();
        });

        Thread t3 = new Thread(() -> {
            C.get();
            countDownLatch.countDown();
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return A.a + B.b + C.c;
    }

    ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3, 4, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3));

    int addUseTl() throws ExecutionException, InterruptedException {


        Callable<Integer> r1 = A::get;
        Callable<Integer> r2 = B::get;
        Callable<Integer> r3 = C::get;
        Future<Integer> submit1 = threadPool.submit(r1);
        Future<Integer> submit2 = threadPool.submit(r2);
        Future<Integer> submit3 = threadPool.submit(r3);

        while (!submit1.isDone() || !submit2.isDone() && !submit3.isDone()) ;
        threadPool.shutdown();
        return submit1.get() + submit2.get() + submit3.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //System.out.println("new MeituanAdd().add() = " + new MeituanAdd().add());
        MeituanAdd meituanAdd = new MeituanAdd();
        System.out.println("meituanAdd.addUseTl() = " + meituanAdd.addUseTl());
    }

}
