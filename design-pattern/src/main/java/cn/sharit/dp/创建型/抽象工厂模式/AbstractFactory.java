package cn.sharit.dp.创建型.抽象工厂模式;

public interface AbstractFactory {

    Phone makePhone(); // 生产手机

    PC makePC(); // 生产电脑

}
