package cn.sharit.算法.查找算法.斐波那契查找;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci.fi(i) + "\t");
        }
    }

    /**
     * @param n > 0
     */
    int fi(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fi(n - 1) + fi(n - 2);
    }
}
