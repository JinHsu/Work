package cn.sharit.算法.查找算法.二分查找;

/**
 * 二分查找（要求查找集合必须有序）
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 9, 10, 12, 88, 123, 432, 1321};
        BinarySearch binarySearch = new BinarySearch();
        int i = binarySearch.search(arr, 0, arr.length - 1, 2);
        System.out.println(i);
        i = binarySearch.search(arr, 432);
        System.out.println(i);
    }

    /**
     * 递归法
     *
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

        int mid = (low + high) / 2;
        if (val < arr[mid]) {
            return search(arr, low, mid - 1, val);
        } else if (val > arr[mid]) {
            return search(arr, mid + 1, high, val);
        } else {
            return mid;
        }
    }

    /**
     * 非递归法
     *
     * @param arr 目标数组
     * @param val 查找的值
     * @return 如果找到，返回目标数组对应下标；否则，返回-1
     */
    int search(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;

        if (val < arr[low] || val > arr[high]) {
            return -1;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (val == arr[mid]) {
                return mid;
            } else if (val < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


}
