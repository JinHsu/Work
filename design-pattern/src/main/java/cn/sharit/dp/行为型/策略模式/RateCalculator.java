package cn.sharit.dp.行为型.策略模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 年利率计算器
 */
public class RateCalculator {

    // 如果使用Spring容器可以交给Spring去处理
    private final List<Rate> rates = new ArrayList<>();

    public RateCalculator(double deposit) {
        rates.add(new Rate1(deposit));
        rates.add(new Rate2(deposit));
        rates.add(new Rate3(deposit));
        rates.add(new Rate4(deposit));
        rates.add(new Rate5(deposit));
    }

    float calc() {
        for (Rate rate : rates) {
            if (rate.support()) {
                return rate.rate();
            }
        }
        return 0.00f;
    }

}
