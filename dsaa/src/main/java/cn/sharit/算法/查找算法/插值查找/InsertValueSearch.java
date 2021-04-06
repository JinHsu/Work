package cn.sharit.算法.查找算法.插值查找;

/**
 * 插值查找（要求查找集合必须有序）
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 9, 10, 12, 88, 123, 432, 1321};
        InsertValueSearch insertValueSearch = new InsertValueSearch();
        int i = insertValueSearch.search(arr, 0, arr.length - 1, 2);
        System.out.println(i);
    }

    /**
     * @param arr  目标数组
     * @param low  起始下标
     * @param high 结束下标
     * @param val  查找的值
     * @return 如果找到，返回目标数组对应下标；否则，返回-1
     */
    int search(int[] arr, int low, int high, int val) {
        if (low > high || val < arr[low] || val > arr[high]) {
            return -1;
        }

        int mid = low + (high - low) * (val - arr[low]) / (arr[high] - arr[low]);
        if (val < arr[mid]) {
            return search(arr, low, mid - 1, val);
        } else if (val > arr[mid]) {
            return search(arr, mid + 1, high, val);
        } else {
            return mid;
        }

    }

}
