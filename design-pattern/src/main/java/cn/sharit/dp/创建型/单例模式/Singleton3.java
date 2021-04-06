package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：线程不安全
 */
public class Singleton3 {

    private static Singleton3 INSTANCE;

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }

    private Singleton3() {
    }

}
