package cn.sharit.juc._01base;

/**
 * 应用程序守护者，当应用程序的所有线程执行完毕，守护线程也会退出
 */
public class Thread_07_daemon {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T());
//        t1.setDaemon(true);

        t1.start();

        Thread.sleep(2000);

    }

    static class T implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("==");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }

    }

}
