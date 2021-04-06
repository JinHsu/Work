package cn.sharit.算法.排序算法.基数排序;

import java.util.Arrays;

/**
 * 基数排序（桶排序），默认10个桶不支持负数，若要支持，还需要添加9个（-9到-1）支持负数的桶
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {888, 6666, 44, 78781, 20, 1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 5, 123, 432, 99, 56, 1321};
        RadixSort radixSort = new RadixSort();
        radixSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        final int[][] buckets = new int[10][arr.length]; // 10个桶
        final int[] size = new int[10]; // 记录每个桶的元素个数
        // 查找最大的数
        int max = 0;
        for (int value : arr) {
            if (max < value) {
                max = value;
            }
        }
        final int maxLength = (max + "").length();

        //
        for (int i = 0, div = 1; i < maxLength; i++, div *= 10) {
            // 遍历数组元素，放到桶内
            for (int j = 0; j < arr.length; j++) {
                int mod = arr[j] / div % 10; // 余数
                buckets[mod][size[mod]] = arr[j];
                size[mod]++;
            }
            // 取出桶内的元素，放到原数组
            int t = 0;
            for (int j = 0; j < buckets.length; j++) {
                // 取出第j个桶内的元素放到元素组
                for (int k = 0; k < size[j]; k++) {
                    arr[t] = buckets[j][k];
                    t++;
                }
                // 重置桶内元素个数
                size[j] = 0;
            }
        }
    }

}
