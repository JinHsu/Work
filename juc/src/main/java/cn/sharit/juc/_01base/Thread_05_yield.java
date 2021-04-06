package cn.sharit.juc._01base;

public class Thread_05_yield {

    public static void main(String[] args) {
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        Thread t3 = new Thread(new T());
        t1.start();
        t2.start();
        t3.start();
    }

    static class T implements Runnable {

        @Override
        public void run() {
            System.out.println("before yield:" + Thread.currentThread().getName());
            Thread.yield(); // 让出自己的执行权，让所有的线程（包括自己）竞争执行权
            System.out.println("after yield:" + Thread.currentThread().getName());
        }

    }

}
