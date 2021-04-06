package cn.sharit.dp.结构型.桥接模式;

public class Computer {

    private final Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }

}
