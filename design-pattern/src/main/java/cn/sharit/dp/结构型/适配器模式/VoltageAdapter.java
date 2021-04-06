package cn.sharit.dp.结构型.适配器模式;

public class VoltageAdapter
        /*extends Voltage220V // 1.也可以使用继承 */
        implements IVoltage {

    private final Voltage220V voltage220V; // 2.也可以使用聚合/组合

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    @Override
    public int output5V() {
        int output = voltage220V.output();
        int i = output / 44;
        System.out.println("适配器转换后电压：" + i + "V");
        return i;
    }

}
