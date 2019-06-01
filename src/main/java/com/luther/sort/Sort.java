package com.luther.sort;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/5/28 21:53
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public interface Sort<T extends Comparable<T>> {
    void sort(T[] values);
     static <T> T[] of(T... values) {
        return values;
    }
}
