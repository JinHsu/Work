package cn.sharit.算法.排序算法.交换排序;

import java.util.Arrays;

/**
 * 冒泡排序，时间复杂度O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 5};
        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(arr);
        bubbleSort.sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // n个元素，n次
            for (int j = 0; j < arr.length - 1 - i; j++) { // 未排序的元素
                if (arr[j] > arr[j + 1]) {
                    //交换
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 优化
     */
    void sort2(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) { // n个元素，n次
            for (int j = 0; j < arr.length - 1 - i; j++) { // 未排序的元素
                if (arr[j] > arr[j + 1]) {
                    //交换
                    swapped = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!swapped) { // 没有发生交换说明是有序的
                break;
            } else {
                swapped = false;
            }
        }

    }

}
