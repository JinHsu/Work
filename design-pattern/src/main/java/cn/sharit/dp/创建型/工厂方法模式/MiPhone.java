package cn.sharit.dp.创建型.工厂方法模式;

public class MiPhone implements Phone {

    public MiPhone() {
        make();
    }

    @Override
    public void make() {
        System.out.println("生产小米手机");
    }
}
