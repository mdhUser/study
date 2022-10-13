package org.maxwell.se.base.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {


    public static void main(String[] args) {

        try {

            ServerSocket ss = new ServerSocket(8888);
            System.out.println("监听端口号：8888");
            Socket s = ss.accept();
            System.out.println("有连接过来" + s);

            InputStream is = s.getInputStream();
            int msg = is.read();
            System.out.println(msg);
            is.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}