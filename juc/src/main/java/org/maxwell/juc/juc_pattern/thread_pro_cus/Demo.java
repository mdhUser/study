package org.maxwell.juc.juc_pattern.thread_pro_cus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/9/3 17:26
 */
public class Demo {


    public static void main(String[] args) throws IOException {
        Logger logger = new Logger();
        logger.start();

        try {
            logger.info("123");
            logger.info("43");
            TimeUnit.MILLISECONDS.sleep(500);
            logger.stop();
            logger.error("e333");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
