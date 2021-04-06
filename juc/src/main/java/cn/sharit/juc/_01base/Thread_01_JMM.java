package cn.sharit.juc._01base;

import java.util.concurrent.TimeUnit;

/**
 * 原子性，可见性，有序性
 */
public class Thread_01_JMM {

    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2000; i++) {
            new Thread(() -> {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
