package cn.sharit.juc._01base;

public class Thread_06_volatile {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T());
        t1.start();
        Thread.sleep(100);
        flag = false;

    }

    static volatile boolean flag = true; // 可见性
    //    static boolean flag = true;
    int i = 0;

    static class T implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (!flag) {
                    System.out.println("flag=" + true);
                    break;
                }
            }
        }

    }
}
