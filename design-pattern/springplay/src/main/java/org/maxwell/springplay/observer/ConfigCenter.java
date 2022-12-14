package org.maxwell.springplay.observer;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  模拟配置中心, nacos/zookeeper/redis/MySQL等均可。 作者：极海Channel https://www.bilibili.com/read/cv14249669?spm_id_from=333.999.0.0 出处：bilibili
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/12/14 22:20
 */
public class ConfigCenter {

    private static Map<String, String> sendMsgConfig = new HashMap<>();
    static {
        sendMsgConfig.put("bizType1", "email,sms");
        sendMsgConfig.put("bizType2", "sms");
    }
    // 根据业务获取配置，新业务，配置key-value即可
    public static List<String> getStrategy(String bizType) {
        return Lists.newArrayList(sendMsgConfig.get(bizType).split(","));
    }


}
