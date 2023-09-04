package org.maxwell.juc.thread_per_message;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/8/30 14:14
 */
@Slf4j
public class NioServerDemo {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open().bind(new InetSocketAddress(8080));

        ExecutorService executorService = Executors.newFixedThreadPool(10);


        while (true){
            SocketChannel socketChannel = serverSocketChannel.accept();
            executorService.submit(()->{
                try {
                    ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                    int read = socketChannel.read(buffer);
                    byte[] bytes = new byte[read];
                    buffer.flip();
                    //从缓冲区中获取内容
//                    buffer.get(bytes);
                    log.info(new String(bytes, StandardCharsets.UTF_8));
                    socketChannel.write(buffer);
                    buffer.clear();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }






    }



}
