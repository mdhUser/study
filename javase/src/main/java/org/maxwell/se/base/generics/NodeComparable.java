package org.maxwell.se.base.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树算法
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/2/15 11:09
 */
public class NodeComparable<T extends Comparable<T>> {

    private NodeComparable<T> leftNode;

    private NodeComparable<T> rightNode;

    private T value;

    public void add(T t) {

        if (null == value) value = t;

        else {
            if (t.compareTo(value) <= 0) {
                if (null == leftNode) leftNode = new NodeComparable<>();
                leftNode.add(t);
            } else {
                if (null == rightNode) rightNode = new NodeComparable<>();
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
