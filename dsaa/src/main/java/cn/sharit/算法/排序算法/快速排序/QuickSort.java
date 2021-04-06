package cn.sharit.算法.排序算法.快速排序;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {20, 1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 3};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr  需要排序的数组
     * @param low  数组起始下标
     * @param high 数组结束下标
     */
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int index = index(arr, low, high);
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }

    public int index(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {

            while (low < high && arr[high] >= temp) {
                high--;
            }

            arr[low] = arr[high];

            while (low < high && arr[low] < temp) {
                low++;
            }

            arr[high] = arr[low];
        }
        // low == high
        arr[low] = temp;
        return low;
    }

}
