package org.maxwell.juc.collectionsync;

import java.util.*;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/5/24 10:57
 */
public class Demo {


    public static void main(String[] args) {

        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
        Set<Object> objects = Collections.synchronizedSet(new HashSet<>());

    }


}
