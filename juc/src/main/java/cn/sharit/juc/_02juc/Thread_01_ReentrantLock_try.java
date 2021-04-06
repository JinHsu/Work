package cn.sharit.juc._02juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: 重入锁
 */
public class Thread_01_ReentrantLock_try {
    static ReentrantLock lock = new ReentrantLock();

    static class T implements Runnable {

        @Override
        public void run() {
            try {
                // lock.tryLock() 不带参数，会立即返回
                if (lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println(Thread.currentThread().getId() + " get lock success");
                    Thread.sleep(3000);
                } else {
                    System.out.println(Thread.currentThread().getId() + " get lock failed");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getId() + " exit. ");
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
