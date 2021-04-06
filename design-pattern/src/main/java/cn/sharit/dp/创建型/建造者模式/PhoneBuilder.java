package cn.sharit.dp.创建型.建造者模式;

public interface PhoneBuilder {

    PhoneBuilder buildCamera();

    PhoneBuilder buildScreen();

    PhoneBuilder buildBattery();

    Phone build();

    // ...

}
