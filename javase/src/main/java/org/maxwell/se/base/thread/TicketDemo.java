package org.maxwell.se.base.thread;

/**
 * 线程测试
 */
public class TicketDemo {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(ticket, "黄牛1").start();
        new Thread(ticket, "黄牛2").start();
        new Thread(ticket, "黄牛3").start();

    }
}


class Ticket implements Runnable {
    Object obj = new Object();
    private int count = 100;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        while (true) {
            synchronized (obj) {
                if (count > 0) {
                    count--;
                    System.out.println(name + "收票！余票：" + count);
                } else {
                    System.out.println("票已抢完！");
                    break;
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


}