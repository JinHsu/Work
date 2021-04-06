package cn.sharit.算法.排序算法.归并排序;

import java.util.Arrays;

/**
 * 归并排序（分治排序）
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {20, 1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 3};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length - 1, new int[arr.length]);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            // 分
            sort(arr, low, mid, temp);
            sort(arr, mid + 1, high, temp);
            // 和
            merge(arr, low, mid, high, temp);
        }
    }

    void merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid + 1;

        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        //
        for (int n = low; n <= high; n++) {
            arr[n] = temp[n - low];
        }
        // System.arraycopy(temp, 0, arr, low, high + 1 - low);
    }


}
