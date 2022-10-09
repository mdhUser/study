package org.maxwell.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/10/9 21:05
 */
public class LookGC {

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
        for (int i = 0; i < 50; i++) {
            data = new byte[100 * 1024];
        }
        data = null;
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
