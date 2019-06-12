package com.luther.sort;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/6/12 22:23
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class BubbleSortMyself<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 7, 1, 5, 2, 1, 9, 5, 4);
        BubbleSortMyself<Integer> sort = new BubbleSortMyself<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    @Override
    public void sort(T[] values) {
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                T temp = values[i];
                if (values[i].compareTo(values[j]) > 0) {
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
    }
}
