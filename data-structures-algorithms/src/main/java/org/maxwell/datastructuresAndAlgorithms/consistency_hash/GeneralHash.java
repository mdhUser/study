package org.maxwell.datastructuresAndAlgorithms.consistency_hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/4 13:55
 */
public class GeneralHash {

    public static void main(String[] args) {
        //定义client
        String[] clients = {"10.78.12.3", "113.25.63.1", "126.12.3.8"};

        //定义服务器数量，要是下线一个就会发现结果变化挺大的，这就是普通哈希的不好地方，服务器节点越多影响越大
        int serverCount = 5;
        //根据index路由到服务器
        for (String client : clients) {
            int hashCode = Math.abs(client.hashCode());
            int index = hashCode % serverCount;
            System.out.println("客户端：" + client + " 被路由到服务器编号为：" +
                    index);
        }
    }


}
