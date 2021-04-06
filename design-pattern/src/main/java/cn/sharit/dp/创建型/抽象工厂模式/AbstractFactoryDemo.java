package cn.sharit.dp.创建型.抽象工厂模式;

/**
 * 工厂可以生产本系列的各种产品
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractFactory appleFactory = new AppleFactory();
        appleFactory.makePhone();
        appleFactory.makePC();

        AbstractFactory miFactory = new MiFactory();
        miFactory.makePhone();
        miFactory.makePC();

    }

}
