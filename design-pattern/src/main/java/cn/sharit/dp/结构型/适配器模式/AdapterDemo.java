package cn.sharit.dp.结构型.适配器模式;

/**
 * 适配器模式
 */
public class AdapterDemo {

    public static void main(String[] args) {
        Voltage220V voltage220V = new Voltage220V();
        VoltageAdapter adapter = new VoltageAdapter(voltage220V); // 输入220V
        adapter.output5V(); // 输出5V
    }
}
