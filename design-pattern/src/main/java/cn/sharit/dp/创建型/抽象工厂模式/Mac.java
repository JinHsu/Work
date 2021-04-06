package cn.sharit.dp.创建型.抽象工厂模式;

public class Mac implements PC {

    public Mac() {
        make();
    }

    @Override
    public void make() {
        System.out.println("生产Mac电脑");
    }
}
