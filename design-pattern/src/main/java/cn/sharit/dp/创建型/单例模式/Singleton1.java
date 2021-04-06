package cn.sharit.dp.创建型.单例模式;

/**
 * 饿汉模式：静态变量
 */
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {
        return INSTANCE;
    }

    private Singleton1() {
    }

}
