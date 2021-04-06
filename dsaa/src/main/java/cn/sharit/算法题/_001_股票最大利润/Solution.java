package cn.sharit.算法题._001_股票最大利润;

/**
 * 动态规划解决
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {10, 7, 1, 5, 3, 8, 6, 4, 7};

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int value : arr) {
            if (min > value) {
                min = value;
            }

            if (value - min > maxProfit) {
                maxProfit = value - min;
            }

        }

        System.out.println(maxProfit);
    }
}
