package cn.sharit.dp.创建型.抽象工厂模式;

public class iPhone implements Phone {

    public iPhone() {
        make();
    }

    @Override
    public void make() {
        System.out.println("生产苹果手机");
    }
}
