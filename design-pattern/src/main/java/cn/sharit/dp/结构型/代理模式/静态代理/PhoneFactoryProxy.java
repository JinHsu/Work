package cn.sharit.dp.结构型.代理模式.静态代理;

public class PhoneFactoryProxy implements PhoneFactory {

    private final PhoneFactory phoneFactory;

    public PhoneFactoryProxy(PhoneFactory phoneFactory) {
        this.phoneFactory = phoneFactory;
    }

    @Override
    public void make() {
        System.out.println("start....");
        phoneFactory.make();
        System.out.println("end....");
    }
}
