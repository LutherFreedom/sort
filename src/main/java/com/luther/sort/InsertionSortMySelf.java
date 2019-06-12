package com.luther.sort;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/6/12 22:28
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class InsertionSortMySelf<T extends Comparable<T>> implements Sort<T> {
    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 7, 1, 5, 2, 1, 9, 5, 4);
        InsertionSortMySelf<Integer> sort = new InsertionSortMySelf<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    @Override
    public void sort(T[] values) {
        int size = values.length;
        for (int i = 0; i < size; i++) {
            T temp = values[i];
            int j;
            for (j = i - 1; j > -1; j--) {
                if (temp.compareTo(values[j]) < 1) {
                    values[j + 1] = values[j];
                } else {
                    break;
                }
            }
            values[j + 1] = temp;
        }
    }
}
