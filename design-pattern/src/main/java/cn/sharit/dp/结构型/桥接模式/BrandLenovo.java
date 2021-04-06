package cn.sharit.dp.结构型.桥接模式;

public class BrandLenovo implements Brand {
    @Override
    public void sale() {
        System.out.println("销售联想品牌");
    }
}
