package org.maxwell.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/1/31 10:39
 */
@ConfigurationProperties(prefix = "mdh.test")
public class HelloProperties {

    private static final String SERVICE_NAME = "hello-mdh";
    private String count;

    private String ip;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
