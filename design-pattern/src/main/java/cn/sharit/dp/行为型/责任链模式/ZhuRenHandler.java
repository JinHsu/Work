package cn.sharit.dp.行为型.责任链模式;

import java.math.BigDecimal;

public class ZhuRenHandler extends Handler {
    @Override
    void doApprove(BigDecimal money, ApproveChain chain) {
        if (money.doubleValue() > 0) {
            System.out.println("主任审批");
        }
        chain.approve(money);
    }
}
