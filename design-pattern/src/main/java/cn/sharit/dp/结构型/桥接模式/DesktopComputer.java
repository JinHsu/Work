package cn.sharit.dp.结构型.桥接模式;

public class DesktopComputer extends Computer {

    public DesktopComputer(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售台式电脑");
    }
}
