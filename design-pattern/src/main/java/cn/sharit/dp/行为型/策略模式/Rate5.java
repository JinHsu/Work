package cn.sharit.dp.行为型.策略模式;

public class Rate5 implements Rate {

    private final double deposit;

    public Rate5(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public float rate() {
        return 2.70f;
    }

    @Override
    public boolean support() {
        return deposit >= 150000;
    }
}
