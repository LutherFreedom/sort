package com.luther.sort;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/5/30 21:39
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 8, 2, 5, 4);
        InsertionSort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    @Override
    public void sort(T[] values) {
        int length = values.length;
        int low = 0;
        int high = length - 1;
        sort(values, low, high);
    }

    private void sort(T[] values, int low, int high) {
        int partition = partition(values, low, high);
        if (low < high){
            sort(values, low, partition -1);
            sort(values, partition, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] values, int low, int high) {
        //轴点元素选用最大索引的元素
        T pivot = values[high];

        int index = low;

        for (int i = low; i < high; i++) {
            if (pivot.compareTo(values[i]) > 0) {
                T temp = values[index];
                values[index] = values[i];
                values[i] = temp;
                index++;
            }
        }
        T temp = values[index];
        values[index] = values[high];
        values[high] = temp;
        return index;
    }


}
