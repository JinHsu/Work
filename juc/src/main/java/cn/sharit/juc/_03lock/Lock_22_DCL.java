package cn.sharit.juc._03lock;

public class Lock_22_DCL {

    private Lock_22_DCL() {
    }

    private static volatile Lock_22_DCL INSTANCE; // volatile 线程可见性，禁止指令重排序

    public static Lock_22_DCL getInstance() {
        if (INSTANCE == null) {
            synchronized (Lock_22_DCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Lock_22_DCL();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> System.out.println(getInstance().hashCode())).start();
        }
    }

}
