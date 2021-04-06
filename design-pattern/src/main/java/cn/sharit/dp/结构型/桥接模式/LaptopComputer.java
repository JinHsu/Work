package cn.sharit.dp.结构型.桥接模式;

public class LaptopComputer extends Computer {

    public LaptopComputer(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("销售笔记本电脑");
    }
}
