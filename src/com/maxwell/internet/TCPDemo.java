package com.maxwell.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 10:42
 */
public class TCPDemo {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.0.104", 8080);

        OutputStream netOut = socket.getOutputStream();
        netOut.write("嘿！朋友好久不见你在哪里？".getBytes());
        socket.close();

    }

}

class Server {

    public static void main(String[] args) throws IOException {
        // 1 创建服务器端的Socket对象 : ServerSocket类
        ServerSocket serverSocket = new ServerSocket(8080);
        // 2 监听客户端连接,并接受连接，返回一个Socket对象
        //等待客户端的链接
        System.out.println("服务端已启动，监听socket,等待客户端的连接~~~");
        Socket accept = serverSocket.accept();
        System.out.println("有客户端已连接~~~");
        //获取客户端输入流
        InputStream netIn = accept.getInputStream();
        byte[] data = new byte[1024];
        int read = netIn.read(data);
        System.out.println(new String(data, 0, read));

        accept.close();
        serverSocket.close();//todo 一般不关服务器

    }

}