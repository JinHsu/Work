package cn.sharit.dp.创建型.建造者模式;

public class MiPhoneBuilder implements PhoneBuilder {

    private final MiPhone phone = new MiPhone();

    @Override
    public PhoneBuilder buildCamera() {
        System.out.println("建造小米手机的摄像头");
        // phone.setXx
        return this;
    }

    @Override
    public PhoneBuilder buildScreen() {
        System.out.println("建造小米手机的屏幕");
        // phone.setXx
        return this;
    }

    @Override
    public PhoneBuilder buildBattery() {
        System.out.println("建造小米手机的电池");
        // phone.setXx
        return this;
    }

    @Override
    public Phone build() {
        return phone;
    }
}
