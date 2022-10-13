package org.maxwell.se.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/18 9:55
 */
public class InetDemo {
    public static void main(String[] args) throws UnknownHostException {


        InetAddress localHost = InetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        String hostAddress = localHost.getHostAddress();
        System.out.println("hostAddress = " + hostAddress);
        System.out.println("hostName = " + hostName);

        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        String baiduName = baidu.getHostName();
        String baiduAddress = baidu.getHostAddress();
        System.out.println("baiduName = " + baiduName);
        System.out.println("baiduAddress = " + baiduAddress);
    }


}