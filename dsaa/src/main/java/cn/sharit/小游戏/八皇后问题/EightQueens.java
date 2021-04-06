package cn.sharit.小游戏.八皇后问题;

import java.util.Arrays;

/**
 * 八皇后问题
 */
public class EightQueens {

    static final int SIZE = 8; // 棋盘大小（皇后个数）
    int[] resolution = new int[SIZE]; // 一种解法
    int count = 0; // 解法总数

    /**
     * 放置第n个皇后
     *
     * @param n 第n个皇后
     */
    public void set(int n) {
        if (n >= SIZE) {
            // 打印
            System.out.println(Arrays.toString(resolution));
            count++;
            return;
        }
        for (int i = 0; i < SIZE; i++) { // 第i+1列
            resolution[n] = i; // 放置
            if (check(n)) { // 有效，放置下一个
                set(n + 1); // 递归
            }
            // 无效，继续下一列的位置
        }
    }

    /**
     * 检查第n个皇后的位置
     *
     * @param n 第n个皇后
     */
    public boolean check(int n) {
        for (int i = 0; i < n; i++) {
            // 同一列
            if (resolution[i] == resolution[n]) {
                return false;
            }
            // 同一条斜线
            if (resolution[i] - resolution[n] == i - n || resolution[i] - resolution[n] == n - i) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("八皇后");
        EightQueens eightQueens = new EightQueens();
        eightQueens.set(0);
        System.out.println(eightQueens.count);
    }

}
