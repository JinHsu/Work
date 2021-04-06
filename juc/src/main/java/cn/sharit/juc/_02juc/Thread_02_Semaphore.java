package cn.sharit.juc._02juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 限流
 */
public class Thread_02_Semaphore {

    static volatile Semaphore semaphore = new Semaphore(5);

    static volatile AtomicInteger count = new AtomicInteger(1);

    static class T implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(count.getAndIncrement() + "  " + Thread.currentThread().getName() + "  " + semaphore.availablePermits() + "  " + semaphore.getQueueLength());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 100; i++) {
            exec.submit(new T());
        }

        while (true) {
            if (semaphore.availablePermits() == 0) {
                try {
                    TimeUnit.SECONDS.sleep(1);
//                    int permits = semaphore.drainPermits();// 释放全部
                    semaphore.release(5);
                    System.out.println(semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
