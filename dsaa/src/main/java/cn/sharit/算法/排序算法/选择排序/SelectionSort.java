package cn.sharit.算法.排序算法.选择排序;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 5, 3};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 找出最小的元素下标
            int min = arr[i];
            int index = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            // 交换
            if (min < arr[i]) { // 找到了比arr[i]更小的数，则交换
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

}
