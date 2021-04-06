package cn.sharit.juc._02juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class Thread_02_LockSupoort {

    static Integer broker = new Integer(1);

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " start ");
            LockSupport.park(broker);
            System.out.println(Thread.currentThread().getName() + " end ");
        }, "A");

        t1.start();

        System.out.println(Thread.currentThread().getName());

        LockSupport.unpark(t1);
    }

}
