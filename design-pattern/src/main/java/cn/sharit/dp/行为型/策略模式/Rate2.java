package cn.sharit.dp.行为型.策略模式;

public class Rate2 implements Rate {
    private final double deposit;

    public Rate2(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public float rate() {
        return 2.10f;
    }

    @Override
    public boolean support() {
        return deposit >= 10000 && deposit < 50000;
    }
}
