package cn.sharit.dp.创建型.工厂方法模式;

/**
 * 各个产品由各自单独的工厂生产
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        PhoneFactory factory = new MiPhoneFactory();
        factory.makePhone();
        PhoneFactory factory2 = new iPhoneFactory();
        factory2.makePhone();

    }
}
