package org.maxwell.se.base.web;

import java.io.IOException;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1",8888);
            System.out.println(s);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}