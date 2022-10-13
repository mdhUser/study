package org.maxwell.se.internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/19 22:21
 */
public class JucClientDemo {


    public static void main(String[] args) throws IOException, InterruptedException {

        Socket socket = new Socket("127.0.0.1", 6666);


        while (true) {
            ReadThread readThread = new ReadThread(socket);
            WriterThread writerThread = new WriterThread(socket);

            writerThread.start();

            readThread.start();

        }

    }


    static class ReadThread extends Thread {

        private Socket socket;

        public ReadThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            synchronized (socket) {
                System.out.println("开始读取数据~~");
                byte[] buf = new byte[1024];
                try {
                    int read = socket.getInputStream().read(buf);
                    String content = new String(buf, 0, read);
                    System.out.println("读取数据：" + content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket.notify();
                try {
                    socket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class WriterThread extends Thread {

        private Socket socket;

        public WriterThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            synchronized (socket) {
                System.out.println("请输入回复内容：");
                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                try {
                    OutputStream netOut = socket.getOutputStream();
                    netOut.write(next.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.notify();
                    socket.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

}

class JucServerDemo {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("等待客户端连接~~");
            var socket = serverSocket.accept();
            System.out.println("连接客户端成功！");
            while (true) {
                InputStream netIn = socket.getInputStream();
                byte[] buf = new byte[1024];
                int read = netIn.read(buf);
                String content = new String(buf, 0, read);
                System.out.println("收到数据:" + content);
                System.out.println("请输入回复信息：");
                String next = scanner.next();
                OutputStream out = socket.getOutputStream();
                out.write(next.getBytes());
            }

        }

    }

}
