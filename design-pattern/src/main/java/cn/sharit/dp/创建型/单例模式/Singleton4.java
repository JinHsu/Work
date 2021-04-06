package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：线程安全（重量级锁）
 */
public class Singleton4 {

    private static Singleton4 INSTANCE;

    public static synchronized Singleton4 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }

    private Singleton4() {
    }

}
