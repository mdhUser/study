package org.maxwell.juc.thread_per_message;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioClientDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        String message = "Hello, NIO Server!";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes(StandardCharsets.UTF_8));

        socketChannel.write(buffer);

        ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(responseBuffer);

        responseBuffer.flip();
        byte[] responseBytes = new byte[bytesRead];
        responseBuffer.get(responseBytes);

        String responseMessage = new String(responseBytes);
        System.out.println("Received from server: " + responseMessage);
        socketChannel.close();
    }
}
