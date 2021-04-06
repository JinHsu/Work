package cn.sharit.dp.行为型.责任链模式;

import java.math.BigDecimal;

public class YuanZhangHandler extends Handler {
    @Override
    void doApprove(BigDecimal money, ApproveChain chain) {
        if (money.doubleValue() > 5000) {
            System.out.println("院长审批");
        }
        chain.approve(money);
    }
}
