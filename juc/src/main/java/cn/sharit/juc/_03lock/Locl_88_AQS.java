package cn.sharit.juc._03lock;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class Locl_88_AQS {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);
        new Thread(() -> {
            lock.lock();
            // ...
//            lock.unlock();
        }, "A").start();

        System.out.println("");

        new Thread(() -> {
            lock.lock();
            // ...
            lock.unlock();
        }, "B").start();


        new ThreadPoolExecutor.AbortPolicy();
    }
}
