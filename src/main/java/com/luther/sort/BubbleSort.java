package com.luther.sort;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/5/28 21:54
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int size = values.length;

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                T temp = values[i];
                if (temp.compareTo(values[j]) == 1) {
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 8, 2, 5, 1);
        BubbleSort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
