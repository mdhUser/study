package org.maxwell.lg.persistence.io;

import java.io.InputStream;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/5 17:15
 */
public class Resources {

    //获取配置文件输入流存储内存
    public static InputStream getResourcesStream(String path) {
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }

}
