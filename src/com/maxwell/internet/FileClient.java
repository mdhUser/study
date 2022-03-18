package com.maxwell.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * @description: 文件上传与下载
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 14:58
 */
public class FileClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 6666);

        OutputStream out = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("d:/lz/图片/地铁少女.jpg");

//        var fos = new FileOutputStream("src/com/maxwell/das.jpg");

        byte[] data = new byte[1024];
        int len;
        while ((len = fis.read(data)) != -1) {
            out.write(data, 0, len);
        }
        socket.shutdownOutput();
        socket.close();
    }

}
    class FileServer {
        public static void main(String[] args) throws IOException {
            var serverSocket = new ServerSocket(6666);
            var threadPool = Executors.newFixedThreadPool(50);
            while (true) {
                System.out.println("等待用户上传文件~~");
                Socket socket = serverSocket.accept();
                System.out.println("用户上传建立连接，开始上传~~");
                threadPool.submit(new FileUpload(socket));
            }

        }

        static class FileUpload implements Runnable {

            private final Socket socket;

            FileUpload(Socket socket) {
                this.socket = socket;
            }

            @Override
            public void run() {
                FileOutputStream fos = null;
                try {
                    String fileName = String.valueOf(UUID.randomUUID());
                    fos = new FileOutputStream("src/com/maxwell/%s.jpg".formatted(fileName));
                    var in = socket.getInputStream();
                    byte[] data = new byte[1024];
                    int len;
                    while ((len = in.read(data)) != -1) {
                        fos.write(data, 0, len);
                    }
                    System.out.println(new File("src/com/maxwell/%s.jpg".formatted(fileName)).exists() ? "文件接受成功已保存到云盘！" : "文件接受失败！");

                } catch (IOException e) {
                    System.out.println("文件上传失败！");
                } finally {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
