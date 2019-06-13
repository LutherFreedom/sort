package com.luther.sort;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/6/13 22:52
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 7, 1, 5, 2, 1, 9, 5, 4);
        MergeSort<Integer> sort = new MergeSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    @Override
    public void sort(T[] values) {
        int size = values.length;
        int low = 0;
        int high = size - 1;
        sortReal(values, low, high);
    }

    private void sortReal(T[] values, int low, int high) {
        if (high > low) {
            int mid = (low + high) / 2;
            sortReal(values, low, mid);
            sortReal(values, mid + 1, high);
            merge(values, low, mid, high);
        }
    }

    private void merge(Comparable[] values, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        Comparable[] arr1 = new Comparable[n1];
        Comparable[] arr2 = new Comparable[n2];
        System.arraycopy(values, low, arr1, 0, n1);
        System.arraycopy(values, mid + 1, arr2, 0, n2);
        int index = low;
        int i = 0, j = 0;
        for (; i < n1 && j < n2; index++) {
            // 如果 a1 与 a2 比较
            if (arr1[i].compareTo(arr2[j]) < 1) {  // <=
                values[index] = arr1[i]; // 低位数值
                i++;
            } else { // >
                values[index] = arr2[j];
                j++;
            }
        }

        // i = 2,n = 3
        // values[k = 0] =  2

        // 复制 a1 剩余元素
        while (i < n1) {
            values[index] = arr1[i];
            i++;
            index++;
        }

        // 复制 a2 剩余元素
        while (j < n2) {
            values[index] = arr2[j];
            j++;
            index++;
        }
    }

}
