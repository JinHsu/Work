package cn.sharit;

public class Test {

    int i = 0;

    public void lock() {
        synchronized (this) {
            i++;
        }
    }

    public synchronized void sync() {
        i++;
    }

    public void sync1() {
        i++;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10000 * 10000; i++) {

            int n = i & (i - 1);

            if (n == 0) {
                System.out.println(i);
            }
        }
    }

}
