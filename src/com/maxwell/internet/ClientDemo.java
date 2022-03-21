package com.maxwell.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 11:45
 */
public class ClientDemo {

    public static void main(String[] args) throws IOException {
        //1.创建客户端的Socket对象
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("127.0.0.1", 8888);
        while (true) {
            System.out.println("请输入发送复信息:");
            OutputStream out = socket.getOutputStream();
            String msg = sc.next();
            out.write(msg.getBytes(StandardCharsets.UTF_8));
            InputStream in = socket.getInputStream();
            byte[] data = new byte[1024];
            int len=in.read(data);
            System.out.println("客户端收到服务端数据：" + new String(data, 0, len));
            if ("886".equals(msg)) {
                System.out.println("结束通话");
                break;
            }
        }

    }
}

class ServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while (true) {
            System.out.println("等待客户端连接~~");
            Scanner sc = new Scanner(System.in);
            var accept = serverSocket.accept();
            while (true) {
                InputStream in = accept.getInputStream();
                byte[] data = new byte[1024];
                int read = in.read(data);
                System.out.println("服务端接受数据：" + new String(data, 0, read));
                System.out.println("输入回复信息：");
                String next = sc.next();
                OutputStream out = accept.getOutputStream();
                out.write(next.getBytes(StandardCharsets.UTF_8));
                if ("886".equals(next)){
                    System.out.println("结束会话");
                    break;
                }
            }
            accept.close();
        }

    }

}