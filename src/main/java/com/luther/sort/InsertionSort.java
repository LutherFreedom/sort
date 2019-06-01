package com.luther.sort;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/5/28 22:15
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int size = values.length;
//        for (int i = 1; i < size; i++) {
//            T temp = values[i];
//            int j;
//            for (j = 0; j < i; j++) {
//                if (temp.compareTo(values[j]) < 1) {
//                    values[j + 1] = values[j];
//                }
//            }
//            values[j] = temp;
//
//        }

        //第二种 替换次数更少
        for (int i = 1; i < size; i++) {
            T temp = values[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (temp.compareTo(values[j]) < 1) {
                    values[j + 1] = values[j];
                } else {
                    break;
                }
            }
            values[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 8, 2, 5, 1);
        InsertionSort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }


}
