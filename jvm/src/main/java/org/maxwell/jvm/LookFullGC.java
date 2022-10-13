package org.maxwell.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/10/9 22:14
 */
public class LookFullGC {

    public static void main(String[] args) {
        try {
            TimeUnit.MILLISECONDS.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            loadData();
        }
    }

    private static void loadData() {
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data = new byte[10 * 1024 * 1024];
        }
        data = null;
        byte[] data1 = new byte[10 * 1024 * 1024];
        byte[] data2 = new byte[10 * 1024 * 1024];
        byte[] data3 = new byte[10 * 1024 * 1024];
        data3 = new byte[10 * 1024 * 1024];
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
