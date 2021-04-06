package cn.sharit.dp.创建型.简单工厂模式;

/**
 * 根据产品类型生产对应的产品（单一工厂生产所有产品）
 * <p>简单工厂模式也称静态工厂模式，因为通常把生产方法设为<code>static</code></p>
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone iPhone = factory.makePhone("iPhone");
        MiPhone miPhone = (MiPhone) factory.makePhone("MiPhone");
    }

}
