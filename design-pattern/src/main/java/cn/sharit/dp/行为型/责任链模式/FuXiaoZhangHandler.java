package cn.sharit.dp.行为型.责任链模式;

import java.math.BigDecimal;

public class FuXiaoZhangHandler extends Handler {

    @Override
    void doApprove(BigDecimal money, ApproveChain chain) {
        if (money.doubleValue() > 10000) {
            System.out.println("副校长审批");
        }
        chain.approve(money);
    }
}
