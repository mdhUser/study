package org.maxwell.se.internet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: 自定义文件传输协议 /r/n
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/19 9:48
 */
public class ProtocolClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream out = socket.getOutputStream();
        File file = new File("d:/lz/图片/早街.jpeg");
        FileInputStream fis = new FileInputStream(file);
        if (file.exists()) {
            String name = file.getName() + "\r\n";
            out.write(name.getBytes());
            byte[] data = new byte[1024];
            int len;
            while ((len = fis.read(data)) != -1) {
                out.write(data, 0, len);
            }
            socket.shutdownOutput();
        } else if (!file.isFile()) {
            System.out.println("该文件不是文件！！！");
        } else throw new RuntimeException("文件不存在！！！");
        System.out.println("上传结束！！！");
        socket.close();


    }


}


class ProtocolServer {

    public static void main(String[] args) throws IOException {
        var server = new ServerSocket(8888);
        while (true) {
            System.out.println("监听客户端连接~~~");
            Socket socket = server.accept();
            System.out.println("监听到客户端开始建立连接~~~");
            var inputStream = socket.getInputStream();
            try (InputStreamReader isr = new InputStreamReader(inputStream);
                 BufferedReader br = new BufferedReader(isr)) {
                System.out.println("开始保存到云端~~");
                String fileName = br.readLine();
                FileOutputStream fos = new FileOutputStream("src/com/maxwell/" + fileName);
                byte[] buf = new byte[1024];
                int len;
                while ((len = inputStream.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                }
                System.out.println(new File("src/com/maxwell/" + fileName).exists() ? "上传成功~" : "上传失败~");
            }
            socket.close();
        }
    }


}