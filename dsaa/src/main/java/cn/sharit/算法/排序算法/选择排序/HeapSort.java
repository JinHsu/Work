package cn.sharit.算法.排序算法.选择排序;

import java.util.Arrays;

/**
 * <h1>堆排序</h1>
 * <p>堆排序也是一种选择排序。</p>
 * <b>满足堆的条件：</b>
 * <ul>
 *     <li>完全二叉树</li>
 *     <li>大顶堆或小顶堆的结构</li>
 * </ul>
 *
 * <p>大顶堆：int[] arr = {7,6,5,1,3,4,2}</p>
 * <p>小顶堆：int[] arr = {1,4,3,5,8,8,6}</p>
 *
 * <b>大顶堆的结构</b>
 * <p>当前节点的值必须大于或等于左右孩子节点的值。arr[i] >= arr[2i+1] 且 arr[i] >= arr[2i+2]，i为堆数组下标</p>
 * <b>小顶堆的结构</b>
 * <p>当前节点的值必须小于或等于左右孩子节点的值。arr[i] <= arr[2i+1] 且 arr[i] <= arr[2i+2]，i为堆数组下标</p>
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 12, 11, 3, 77, 22, -99, 32};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * <ol>
     *     <li>将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆；</li>
     *     <li>将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端；</li>
     *     <li>重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。</li>
     * </ol>
     */
    public void sort(int[] arr) {
        // 1.构建大顶堆
//        for (int i = arr.length / 2 - 1; i >= 0; i--) {
//            adjustHeap(arr, i, arr.length);
//        }

        for (int i = arr.length; i > 0; i--) {
            // 1.构建大顶堆
            for (int j = i / 2; j >= 0; j--) {
                adjustHeap(arr, j, i);
            }

            // 2.交换首末
            swap(arr, 0, i - 1);
        }

    }

    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }

    /**
     * 交换元素
     */
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
