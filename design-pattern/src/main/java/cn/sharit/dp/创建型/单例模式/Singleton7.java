package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：双重检测锁（DCL）+ volatile
 */
public class Singleton7 {

    private static volatile Singleton7 INSTANCE;

    public static Singleton7 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton7.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton7();
                }
            }
        }
        return INSTANCE;
    }

    private Singleton7() {
    }

}
