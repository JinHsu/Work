package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：静态内部类
 */
public class Singleton8 {

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }

    private Singleton8() {
    }

    private static class Singleton {
        // JVM 类加载机制（线程安全）
        private static final Singleton INSTANCE = new Singleton();
    }

}
