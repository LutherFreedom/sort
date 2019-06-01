package com.luther.sort;

/**
 * All rights Reserved, Designed by Luther
 *
 * @auther: Luther
 * @createdTime: 2019/5/30 23:01
 * @version： 0.0.1
 * @copyRight: @2019
 * TODO:
 */
public class DemoSort {
    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 5, 4};
        sortInt(arr, 0, arr.length -1);
        System.out.println(1);
    }
    public static void sortInt(int arr[], int low, int high) {
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)
                h--;
            if (l < h) {
                arr[l] = arr[h];
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                arr[h] = arr[l];
                h--;
            }
        }
        arr[l] = povit;
        if (l - 1 > low) sortInt(arr, low, l - 1);
        if (h + 1 < high) sortInt(arr, h + 1, high);
    }
}
