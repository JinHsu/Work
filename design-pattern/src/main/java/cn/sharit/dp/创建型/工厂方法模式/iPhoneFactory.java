package cn.sharit.dp.创建型.工厂方法模式;

public class iPhoneFactory implements PhoneFactory {
    @Override
    public Phone makePhone() {
        return new iPhone();
    }
}
