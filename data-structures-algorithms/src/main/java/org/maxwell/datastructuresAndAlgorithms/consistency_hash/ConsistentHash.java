package org.maxwell.datastructuresAndAlgorithms.consistency_hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/4 15:26
 */
public class ConsistentHash {



    //1. 定义服务器IP 把服务器节点IP的哈希值对应到哈希环上
    static String[] tomcatServers = {"123.111.0.0", "123.101.3.1", "111.20.35.2", "123.98.26.3"};

    static class ConsistentHashNoVirtual {

        public static void main(String[] args) {
            //存储哈希环位置和hash值的映射，因为有顺时针方向动作，所以用TreeMap有序
            SortedMap<Integer, String> hashServerMap = new TreeMap<>();
            for (String tomcatServer : tomcatServers) {
                int serverHash = Math.abs(tomcatServer.hashCode());
                //存储hash和IP的映射关系
                hashServerMap.put(serverHash, tomcatServer);
            }

            //2 针对客户端IP求出hash值
            // 定义客户端IP
            String[] clients = new String[]{"10.78.12.3", "113.25.63.1", "126.12.3.8"};
            for (String client : clients) {
                int clientHash = Math.abs(client.hashCode());
                //把值大于或等于clientHash的元素进行排序返回一个maP
                SortedMap<Integer, String> serverMap = hashServerMap.tailMap(clientHash);
                if (serverMap.isEmpty()) {
                    //如果没有比他更大的就是落在第一台服务器
                    Integer firstKey = hashServerMap.firstKey();
                    System.out.println("==========>>>>客户端：" + client + "被路由到服务器" + hashServerMap.get(firstKey));
                } else {
                    Integer firstKey = serverMap.firstKey();
                    System.out.println("==========>>>>客户端：" + client + "被路由到服务器" + serverMap.get(firstKey));
                }
            }

        }


    }


    static class ConsistentHashWithVirtual {
        public static void main(String[] args) {
            //每个节点的虚拟数
            int virtualCount = 3;
            //存储哈希环位置和hash值的映射，因为有顺时针方向动作，所以用TreeMap有序
            SortedMap<Integer, String> hashServerMap = new TreeMap<>();
            for (String tomcatServer : tomcatServers) {
                int serverHash = Math.abs(tomcatServer.hashCode());
                //存储hash和IP的映射关系
                hashServerMap.put(serverHash, tomcatServer);
                //处理虚拟节点
                for (int i = 0; i < virtualCount; i++) {
                    hashServerMap.put((tomcatServer + "#" + i).hashCode(), "----由虚拟节点" + i + "映射过来的请求：" + tomcatServer);
                }

            }
            //2 针对客户端IP求出hash值
            // 定义客户端IP
            String[] clients = new String[]{"10.78.12.3", "113.25.63.1", "126.12.3.8"};
            for (String client : clients) {
                int clientHash = Math.abs(client.hashCode());
                //把值大于或等于clientHash的元素进行排序返回一个map
                //根据客户端ip的哈希值去找出哪⼀个服务器节点能够处理（）
                SortedMap<Integer, String> serverMap = hashServerMap.tailMap(clientHash);
                if (serverMap.isEmpty()) {
                    //如果没有比他更大的就是落在第一台服务器
                    Integer firstKey = hashServerMap.firstKey();
                    System.out.println("==========>>>>客户端：" + client + "被路由到服务器：" + hashServerMap.get(firstKey));
                } else {
                    Integer firstKey = serverMap.firstKey();
                    System.out.println("==========>>>>客户端：" + client + "被路由到服务器：" + serverMap.get(firstKey));
                }
            }
        }

    }


}
