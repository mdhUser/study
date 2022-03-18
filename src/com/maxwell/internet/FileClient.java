package com.maxwell.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

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

        var fos = new FileOutputStream("src/com/maxwell/das.jpg");


        byte[] data = new byte[1024];
        int len;
        while ((len = fis.read(data)) != -1) {
            out.write(data, 0, len);
            fos.write(data, 0, len);
        }
        out.close();
        fos.close();
        socket.close();

    }

}

class FileServer {
    public static void main(String[] args) throws IOException {
        var serverSocket = new ServerSocket(6666);
        new FileServer.FileUpload(serverSocket);

    }

    static class FileUpload implements Runnable {

        private final ServerSocket serverSocket;

        FileUpload(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }


        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("等待客户端连接~~");
                    Socket accept = serverSocket.accept();
                    System.out.println("接收数据开始下载到云盘~~");
                    String fileName = String.valueOf(UUID.randomUUID());
                    FileOutputStream fos = new FileOutputStream("src/com/maxwell/%s.jpg".formatted(fileName));

                    var in = accept.getInputStream();
                    byte[] data = new byte[1024];
                    int len;
                    while ((len = in.read()) != -1) {
                        fos.write(data, 0, len);
                    }
                    System.out.println(new File("src/com/maxwell/%S.jpg".formatted(fileName)).exists() ? "文件接受成功已保存到云盘！" : "文件接受失败！");
                    fos.close();
                    accept.close();
                } catch (IOException e) {
                    System.out.println("文件上传失败！");
                }
            }
        }

    }
}