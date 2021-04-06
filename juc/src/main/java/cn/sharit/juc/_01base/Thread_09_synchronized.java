package cn.sharit.juc._01base;

public class Thread_09_synchronized {

    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(index);
    }

    static int index = 0;

    static class T implements Runnable {

        /*synchronized*/ void incr() {
            index++;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                incr();
            }
        }
    }
}
