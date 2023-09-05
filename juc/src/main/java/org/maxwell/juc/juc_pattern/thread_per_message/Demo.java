package org.maxwell.juc.juc_pattern.thread_per_message;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/29 16:52
 */
@Slf4j
public class Demo {


    public static void main(String[] args) throws IOException {
        final ServerSocketChannel ssc = ServerSocketChannel.open().bind(
                new InetSocketAddress(8080));
        //处理请求
        try {
            while (true) {
                // 接收请求
                SocketChannel sc = ssc.accept();
                // 每个请求都创建一个线程
                new Thread(() -> {
                    try {
                        // 读Socket
                        ByteBuffer rb = ByteBuffer
                                .allocateDirect(1024);
                        sc.read(rb);
                        //模拟处理请求
                        Thread.sleep(2000);
                        // 写Socket
                        ByteBuffer wb = rb.flip();
                        sc.write(wb);
                        // 关闭Socket
                        sc.close();
                    } catch (Exception e) {
                        log.error("输出异常",e);
                    }
                }).start();
            }
        } finally {
            ssc.close();
        }
    }


}
