package cn.sharit.dp.结构型.桥接模式;

public class BrandDell implements Brand {
    @Override
    public void sale() {
        System.out.println("销售戴尔品牌");
    }
}
