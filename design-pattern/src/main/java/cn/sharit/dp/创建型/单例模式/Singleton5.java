package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：同步代码块（线程不安全）
 */
public class Singleton5 {

    private static Singleton5 INSTANCE;

    public static Singleton5 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                INSTANCE = new Singleton5();
            }
        }
        return INSTANCE;
    }

    private Singleton5() {
    }

}
