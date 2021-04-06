package cn.sharit.juc._01base;

public class Thread_05_join {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T());
        t1.start();
        t1.join(); // 主线程等待t1线程执行完毕
        System.out.println(index);
    }

    static volatile int index = 0;
    static final int MAX = 1000 * 1000;

    static class T implements Runnable {

        @Override
        public void run() {
            while (index < MAX) {
                index++; // volatile不保证原子性
            }
        }
    }

}
