package cn.sharit.dp.创建型.单例模式;

/**
 * 懒汉模式：枚举
 */
public class Singleton9 {

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }

    private Singleton9() {
    }

    enum Singleton {
        INSTANCE;
    }

}


