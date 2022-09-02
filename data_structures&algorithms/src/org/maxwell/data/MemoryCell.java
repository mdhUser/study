package src.org.maxwell.data;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/27 20:43
 */
public class MemoryCell<T> {

    private T storedValue;

    public T read() {
        return storedValue;
    }

    public void write(T x) {
        storedValue = x;
    }

}

class TypeComparable {

    public static <T extends Comparable<? super T>> T findMax(T[] arr) {

        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i].compareTo(arr[maxIndex]) > 0)
                maxIndex = i;
        return arr[maxIndex];
    }

}