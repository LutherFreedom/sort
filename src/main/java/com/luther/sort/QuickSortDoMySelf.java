package com.luther.sort;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/6/12 21:55
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class QuickSortDoMySelf<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 7, 1, 5, 2, 1, 9, 5, 4);
        QuickSortDoMySelf<Integer> sort = new QuickSortDoMySelf<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    @Override
    public void sort(T[] values) {
        int size = values.length;
        int low = 0;
        int high = size - 1;
        realSort(values, low, high);
    }

    public <T extends Comparable<T>> void realSort(T[] values, int low, int high) {
        if (low < high) {
            int partition = partition(values, low, high);
            realSort(values, low, partition - 1);
            realSort(values, partition, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] values, int low, int high) {
        T pivot = values[high];
        int index = low;
        for (int i = low; i < high; i++) {
            if (pivot.compareTo(values[i]) >= 0) {
                T temp = values[i];
                values[i] = values[index];
                values[index] = temp;
                index++;
            }
        }
        T temp = values[high];
        values[high] = values[index];
        values[index] = temp;
        return index;
    }

}
