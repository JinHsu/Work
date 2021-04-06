package cn.sharit.算法.查找算法.斐波那契查找;

import java.util.Arrays;

/**
 * 斐波那契查找（黄金分割查找）（要求查找集合必须有序）
 */
public class FibonacciSearch {

    int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    int search(int[] arr, int low, int high, int val) {
        if (low > high || val < arr[low] || val > arr[high]) {
            return -1;
        }

        if (low == high && arr[low] == val) {
            return low;
        }
        // 获取黄金分割点：f(n) = f(n-1) + f(n-2)
        int length = high - low + 1;
        int k = 0;
        while (fibonacci(k) < length) {
            k++;
        }

        int m = low + fibonacci(k - 1) - 1; // 黄金分割点(数组下标)

        // 递归
        if (val < arr[m]) {
            return search(arr, low, m - 1, val);
        } else if (val > arr[m]) {
            return search(arr, m + 1, high, val);
        } else {
            return m;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 9, 10, 12, 88, 123, 432, 1321};
        System.out.println("arr=" + Arrays.toString(arr));
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        int val = 10;
        System.out.println("val=" + val);
        int i = fibonacciSearch.search(arr, 0, arr.length - 1, val);
        System.out.println("index=" + i);
    }


}
