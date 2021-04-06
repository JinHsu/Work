package cn.sharit.juc._01base;

public class Thread_02_interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T());
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

    static class T implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted...");
                    break;
                }

                Thread.yield();
                System.out.println("running...");
            }
        }

    }

}
