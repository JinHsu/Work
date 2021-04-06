package cn.sharit.juc._02juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: 重入锁
 */
public class Thread_01_ReentrantLock {
    static ReentrantLock lock = new ReentrantLock();
    static int count = 0;

    static class T implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        T t = new T();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
