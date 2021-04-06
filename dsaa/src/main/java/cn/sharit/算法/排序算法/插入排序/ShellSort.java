package cn.sharit.算法.排序算法.插入排序;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = new int[]{20, 1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 5, 3};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //
    void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) { // 组内遍历
                // 对分组进行排序，使用插入排序
                for (int j = i + gap; j < arr.length; j += gap) { // 分组
                    for (int k = i; k < j; k += gap) {
                        if (arr[j] < arr[k]) {
                            int temp = arr[j];
                            // 后移
                            for (int m = j; m > k; m -= gap) {
                                arr[m] = arr[m - gap];
                            }
                            arr[k] = temp;
                        }
                    }
                }
            }
        }
    }

}
