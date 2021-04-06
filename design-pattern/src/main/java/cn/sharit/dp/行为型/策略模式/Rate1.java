package cn.sharit.dp.行为型.策略模式;

public class Rate1 implements Rate {
    private final double deposit;

    public Rate1(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public float rate() {
        return 2.0f;
    }

    @Override
    public boolean support() {
        return deposit > 0 && deposit < 10000;
    }
}
