package cn.sharit.dp.创建型.建造者模式;

public class PhoneDirector {

    private PhoneBuilder phoneBuilder;

    public PhoneBuilder miPhoneBuilder() {
        return new MiPhoneBuilder();
    }

    public PhoneBuilder iPhoneBuilder() {
        return new iPhoneBuilder();
    }

}