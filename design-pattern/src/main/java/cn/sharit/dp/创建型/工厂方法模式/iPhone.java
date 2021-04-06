package cn.sharit.dp.创建型.工厂方法模式;

public class iPhone implements Phone {

    public iPhone() {
        make();
    }

    @Override
    public void make() {
        System.out.println("生产苹果手机");
    }
}
