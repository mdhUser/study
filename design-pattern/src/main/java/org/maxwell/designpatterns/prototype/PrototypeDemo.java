package org.maxwell.designpatterns.prototype;

import java.io.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/4 00:06
 */
public class PrototypeDemo {


    public <T extends Cloneable> T shallow(T t){
        return t;
    }


    /**
     * 原型模式深拷贝
     *
     * @param o
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deeCopy(Object o) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(o);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }


}
