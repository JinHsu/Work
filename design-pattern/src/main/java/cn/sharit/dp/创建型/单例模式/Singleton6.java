package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：双重检测锁（DCL）
 */
public class Singleton6 {

    private static Singleton6 INSTANCE;

    public static Singleton6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton6.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }

    private Singleton6() {
    }

}
