package cn.sharit.juc._01base;

import java.util.ArrayList;

/**
 * ArrayList非线程安全; Vector线程安全
 */
public class Thread_10_ArrayList {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(al.size());
    }

    static ArrayList<Integer> al = new ArrayList<>();

    static class T implements Runnable {

        synchronized static void add(int i) {
            al.add(i);
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                add(i);
            }
        }

    }

}
