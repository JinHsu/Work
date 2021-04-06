package cn.sharit.算法题._003_背包问题;

/**
 * 动态规划解决
 * <p>"01背包"，"完全背包"</p>
 */
public class Pkg {

    public static void main(String[] args) {
        Pkg pkg = new Pkg();
        pkg.dynamic();

    }

    /**
     * 动态规划解决"01背包问题"
     */
    public void dynamic() {
        int[] w = {1, 4, 3}; // 物品的重量
        int[] v = {1500, 3000, 2000}; // 物品的价值
        int m = 4; // 背包的容量
        int n = 3; // 物品的个数

        int[][] vc = new int[n + 1][m + 1]; // 最大价值

        // 初始化第一行和第一列
        for (int i = 0; i < m + 1; i++) {
            vc[0][i] = 0; // 第一行
        }
        for (int i = 0; i < n + 1; i++) {
            vc[i][0] = 0; // 第一列
        }

        // 输出
        show(vc);

        int[][] p = new int[n + 1][m + 1];
        // vc[i][j]表示第i个物品放置容量为j的背包中的最大价值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (w[i - 1] > j) {
                    vc[i][j] = vc[i - 1][j];
                } else {
                    int parent = vc[i - 1][j];
                    int current = vc[i - 1][j - w[i - 1]] + v[i - 1];
                    if (current > parent) {
                        p[i][j] = 1;
                    }
                    vc[i][j] = Math.max(parent, current);
                }
            }
        }

        // 输出
        System.out.println("==========================");
        show(vc);


        int row = p.length - 1;
        int col = p[row].length - 1;
        while (row > 0 && col > 0) {
            if (p[row][col] == 1) {
                System.out.println("第" + row + "个物品");
                col -= w[row - 1];
            }
            row--;
        }

    }

    void show(int[][] v) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
