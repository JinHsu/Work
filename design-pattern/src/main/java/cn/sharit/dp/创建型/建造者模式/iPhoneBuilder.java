package cn.sharit.dp.创建型.建造者模式;

public class iPhoneBuilder implements PhoneBuilder {

    private final iPhone phone = new iPhone();

    @Override
    public PhoneBuilder buildCamera() {
        System.out.println("建造苹果手机的摄像头");
        return this;
    }

    @Override
    public PhoneBuilder buildScreen() {
        System.out.println("建造苹果手机的屏幕");
        return this;
    }

    @Override
    public PhoneBuilder buildBattery() {
        System.out.println("建造苹果手机的电池");
        return this;
    }

    @Override
    public Phone build() {
        return phone;
    }
}
