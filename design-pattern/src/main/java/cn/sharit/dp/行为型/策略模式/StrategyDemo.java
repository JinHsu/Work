package cn.sharit.dp.行为型.策略模式;

/**
 * 策略模式
 */
public class StrategyDemo {

    public static void main(String[] args) {

        /*
         * 根据存款获取年利率问题：
         * 1）存款大于1W，年利率2.10%
         * 2）存款大于5W，年利率2.25%
         * 2）存款大于10W，年利率2.5%
         * 2）存款大于15W，年利率2.7%
         */
        RateCalculator calculator = new RateCalculator(160000);
        System.out.println(calculator.calc());


    }
}
