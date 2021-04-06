package cn.sharit.juc._02juc;

import java.util.concurrent.CountDownLatch;

public class Thread_04_CountDownLatch {

    static CountDownLatch countDownLatch = new CountDownLatch(10);

    static class T implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " : " + countDownLatch.getCount());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        final T t = new T();
        for (int i = 0; i < 10; i++) {
            new Thread(t).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " : " + countDownLatch.getCount());
    }
}
