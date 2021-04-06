package cn.sharit.juc._02juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: 公平锁
 */
public class Thread_01_ReentrantLock_fair {
    static ReentrantLock lock = new ReentrantLock(true); // 公平锁

    static class T implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getId() + " 获得锁");
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
    }
}
