package cn.sharit.dp.结构型.桥接模式;

/**
 * 桥接模式：解决类继承膨胀问题；提高了系统的可扩充性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统
 */
public class BridgeDemo {

    public static void main(String[] args) {
        Computer desktop = new DesktopComputer(new BrandLenovo());
        desktop.sale();

        Computer laptop = new LaptopComputer(new BrandDell());
        laptop.sale();
    }
}
