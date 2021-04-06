package cn.sharit.dp.行为型.策略模式;

public class Rate3 implements Rate {
    private final double deposit;

    public Rate3(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public float rate() {
        return 2.25f;
    }

    @Override
    public boolean support() {
        return deposit >= 50000 && deposit < 100000;
    }
}
