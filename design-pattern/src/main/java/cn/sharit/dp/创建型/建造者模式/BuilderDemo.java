package cn.sharit.dp.创建型.建造者模式;

public class BuilderDemo {

    public static void main(String[] args) {
        PhoneDirector phoneDirector = new PhoneDirector();
        Phone phone = phoneDirector.iPhoneBuilder()
                .buildBattery()
                .buildScreen()
                .buildCamera()
                .build();
        System.out.println(phone);
    }

}
