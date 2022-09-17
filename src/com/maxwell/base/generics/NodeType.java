package com.maxwell.base.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树算法
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/15 11:09
 */
public class NodeType<T> {

    NodeType<T> leftNode;

    NodeType<T> rightNode;

    T value;

    public void add(T t) {

        if (null == value) value = t;

        else {
            if ((Integer) t - (Integer) value <= 0) {
                if (null == leftNode) leftNode = new NodeType<>();
                leftNode.add(t);
            } else {
                if (null == rightNode) rightNode = new NodeType<>();
                rightNode.add(t);
            }
        }

    }

    public List<T> values() {
        List<T> values = new ArrayList<>();
        if (null != leftNode) values.addAll(leftNode.values());
        values.add(value);
        if (null != rightNode) values.addAll(rightNode.values());
        return values;
    }


}
