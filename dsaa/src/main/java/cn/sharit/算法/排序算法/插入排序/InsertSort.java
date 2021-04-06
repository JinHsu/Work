package cn.sharit.算法.排序算法.插入排序;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{20, 1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 5, 3};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    // 插入
                    int temp = arr[i];

                    // 后移
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k - 1];
                    }
                    // System.arraycopy(arr, j, arr, j + 1, i - j);
                    //
                    arr[j] = temp;
                }
            }
        }
    }
}
