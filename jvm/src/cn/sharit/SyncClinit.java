package cn.sharit;

public class SyncClinit {

    static class Test {
        static {
            if (true) {
                System.out.println(Thread.currentThread().getName() + ": class Test initing...");
                while (true) {
                }
            }
        }
    }

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " starting...");
                new Test();
                System.out.println(Thread.currentThread().getName() + " end...");
            }
        };

        Thread t1 = new Thread(r);
        t1.setName("t1");
        Thread t2 = new Thread(r);
        t2.setName("t2");

        t1.start();
        t2.start();

    }

}
