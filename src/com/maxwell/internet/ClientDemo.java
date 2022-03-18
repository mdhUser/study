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
        OutputStream out = socket.getOutputStream();
        out.write("fuck U!".getBytes(StandardCharsets.UTF_8));
        while (true) {
            Socket s = new Socket("127.0.0.1", 8888);
            var o = s.getOutputStream();
            var in = s.getInputStream();
            byte[] data = new byte[1024];
            int read = in.read(data);
            if (read==-1){
                socket.close();
                continue;
            }
            System.out.println("客户端接受数据：" + new String(data, 0, read));
            System.out.println("输入回复信息：");
            String next = sc.next();
            o.write(next.getBytes(StandardCharsets.UTF_8));
        }

        //todo 关闭socket
//        socket.close();

    }
}

class ServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("等待客户端连接~~");
            var accept = serverSocket.accept();
            InputStream in = accept.getInputStream();
            byte[] data = new byte[1024];
            int read = in.read(data);
            System.out.println("服务端接受数据：" + new String(data, 0, read));
            System.out.println("输入回复信息：");
            String next = sc.next();
            OutputStream out = accept.getOutputStream();
            out.write(next.getBytes(StandardCharsets.UTF_8));
            accept.close();
        }
    }

}