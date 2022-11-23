package org.maxwell.designpatterns.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/22 14:54
 */
public class ArrayIterator<E> implements Iterator<E> {

    private int cursor;

    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size() - 1;
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public E currentItem() {
        if (cursor > arrayList.size())
            throw new NoSuchElementException();
        return arrayList.get(cursor);
    }
}
