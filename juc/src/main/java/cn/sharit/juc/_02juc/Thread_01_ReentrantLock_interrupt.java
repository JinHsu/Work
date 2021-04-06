package cn.sharit.juc._02juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock: 重入锁，响应中断
 */
public class Thread_01_ReentrantLock_interrupt {
    static ReentrantLock lock1 = new ReentrantLock();
    static ReentrantLock lock2 = new ReentrantLock();

    static class T implements Runnable {

        private final int flag;

        T(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            try {
                if (flag == 1) {
                    lock1.lockInterruptibly(); // 获取lock1
                    Thread.sleep(500);
                    lock2.lockInterruptibly(); // 获取lock2发现被占用
                } else {
                    lock2.lockInterruptibly(); // 获取lock2
                    Thread.sleep(500);
                    lock1.lockInterruptibly(); // 获取lock1返现被占用
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock1.isHeldByCurrentThread()) {
                    lock1.unlock();
                }
                if (lock2.isHeldByCurrentThread()) {
                    lock2.unlock();
                }
                System.out.println(Thread.currentThread().getId() + " 线程退出。");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new T(1));
        Thread t2 = new Thread(new T(2));
        t1.start();
        t2.start();
        Thread.sleep(1000);

        t2.interrupt(); // 打断一个线程
    }
}
