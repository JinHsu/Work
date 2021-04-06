package cn.sharit.juc._01base;

public class Thread_03_wait_notify {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                try {

                    System.out.println("1");
                    lock.wait();
                    System.out.println("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(() -> {
            synchronized (lock) {
                lock.notify();
                System.out.println("3");
            }
        }).start();


//        Thread t1 = new Thread(new T());
//        Thread t2 = new Thread(new S());
//
//        t1.start();
//        t2.start();

    }

    static final Object lock = new Object();

    static class T implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("T start...");
                try {
                    lock.wait(); // 释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T end...");
            }
        }

    }

    static class S implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("S start...");
                lock.notify();
                System.out.println("S end...");
                try {
                    Thread.sleep(3000); // 不会释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
