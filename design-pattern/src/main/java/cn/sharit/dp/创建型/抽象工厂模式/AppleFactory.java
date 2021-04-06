package cn.sharit.dp.创建型.抽象工厂模式;

public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new iPhone();
    }

    @Override
    public PC makePC() {
        return new Mac();
    }
}
