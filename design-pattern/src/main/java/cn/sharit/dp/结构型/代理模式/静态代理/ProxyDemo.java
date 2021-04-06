package cn.sharit.dp.结构型.代理模式.静态代理;

public class ProxyDemo {

    public static void main(String[] args) {
        PhoneFactory phoneFactoryProxy = new PhoneFactoryProxy(new MiPhoneFactory());
        phoneFactoryProxy.make();
    }
}
