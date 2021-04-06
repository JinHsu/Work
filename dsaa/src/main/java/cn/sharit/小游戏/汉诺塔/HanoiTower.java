package cn.sharit.小游戏.汉诺塔;

/**
 * 分治算法解决汉诺塔问题
 */
public class HanoiTower {
    public static void main(String[] args) {
        resolve(5, 'A', 'B', 'C');
    }

    /**
     * @param num 盘子个数
     * @param a   柱子
     * @param b   柱子
     * @param c   柱子
     */
    public static void resolve(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(num + ": " + a + " -> " + c);
        } else {
            // a->b
            resolve(num - 1, a, c, b); //

            // a->c
            System.out.println(num + ": " + a + " -> " + c);

            // b->c
            resolve(num - 1, b, a, c);
        }
    }

}
