package cn.sharit.juc._01base;

/**
 * volatile不保证原子性
 */
public class Thread_06_volatile2 {

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[loopCount];
        for (int i = 0; i < loopCount; i++) {
            ts[i] = new Thread(new T());
            ts[i].start();
        }

        for (int i = 0; i < loopCount; i++) {
            ts[i].join();
        }

        System.out.println(num);
        System.out.println(MAX * loopCount);
    }

    static volatile int num = 0;
    static int MAX = 100000;
    static int loopCount = 10;

    static class T implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < MAX; i++) {
                num++; // volatile不保证原子性
            }
        }

    }
}
