package cn.sharit.dp.创建型.简单工厂模式;

public class PhoneFactory {

    public /*static*/ Phone makePhone(String phoneType) {
        Phone phone = null;
        if (phoneType.equalsIgnoreCase("MiPhone")) {
            phone = new MiPhone();
        } else if (phoneType.equalsIgnoreCase("iPhone")) {
            phone = new iPhone();
        }
        return phone;
    }

}
