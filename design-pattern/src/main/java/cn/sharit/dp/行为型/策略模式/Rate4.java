package cn.sharit.dp.行为型.策略模式;

public class Rate4 implements Rate {

    private final double deposit;

    public Rate4(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public float rate() {
        return 2.50f;
    }

    @Override
    public boolean support() {
        return deposit >= 100000 && deposit < 150000;
    }
}
