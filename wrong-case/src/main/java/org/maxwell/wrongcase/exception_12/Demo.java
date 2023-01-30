package org.maxwell.wrongcase.exception_12;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/29 16:51
 */
@Slf4j
public class Demo {

    static class Resource implements AutoCloseable {

        public void read() throws Exception {
            throw new Exception("read error");
        }

        @Override
        public void close() throws Exception {
            throw new Exception("close error");
        }
    }

    public static void main(String[] args) throws Exception {

        //Resource resource = new Resource();
        //try {
        //    resource.read();
        //} finally {
        //    resource.close();
        //}

        try (Resource resource = new Resource()) {
            resource.read();
        }


    }

}
