package cn.sharit.dp.创建型.单例模式;

/**
 * 饿汉模式：静态代码块
 */
public class Singleton2 {

    private static Singleton2 INSTANCE;

    static {
        INSTANCE = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }

    private Singleton2() {
    }

}
