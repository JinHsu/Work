package cn.sharit.dp.结构型.代理模式.静态代理;

public class MiPhoneFactory implements PhoneFactory {
    @Override
    public void make() {
        System.out.println("生产小米手机");
    }
}
