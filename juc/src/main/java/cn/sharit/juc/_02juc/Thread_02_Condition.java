package cn.sharit.juc._02juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_02_Condition {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    static class T implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getId() + " await");
                condition.await();
                System.out.println(Thread.currentThread().getId() + " exit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            lock.lock();
            try {
                System.out.println("1");
                condition.await();
                System.out.println("2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                condition.signal();
            } finally {
                lock.unlock();
            }
            System.out.println("3");
        }).start();


//        Thread t = new Thread(new T());
//        t.start();
//
//        Thread.sleep(1000);
//
//        System.out.println(lock.getHoldCount());
//        try {
//            lock.lock();
//            System.out.println(Thread.currentThread().getId() + " before signal");
//            condition.signal();
//            System.out.println(Thread.currentThread().getId() + " after signal");
//        } finally {
//            lock.unlock();
//        }

    }
}
