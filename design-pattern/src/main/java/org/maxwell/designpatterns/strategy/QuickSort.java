package org.maxwell.designpatterns.strategy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/18 13:45
 */
public class QuickSort implements ISortAlg {


    @Override
    public void sort(String filePath) {
        File file = new File(filePath);
        try (FileInputStream in = new FileInputStream(file);
             BufferedInputStream buffer = new BufferedInputStream(in)) {
            byte[] content = buffer.readAllBytes();
            quickSort(content, 0, content.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 快排入口
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private byte[] quickSort(byte[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(byte[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(byte[] arr, int i, int j) {
        byte temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
