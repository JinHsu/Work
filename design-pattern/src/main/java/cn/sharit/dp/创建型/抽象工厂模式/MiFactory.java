package cn.sharit.dp.创建型.抽象工厂模式;

public class MiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }

    @Override
    public PC makePC() {
        return new MiBook();
    }
}
