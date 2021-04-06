package cn.sharit.dp.行为型.责任链模式;

import java.math.BigDecimal;

/**
 * 审批流程
 */
public abstract class Handler {

    void apprv(BigDecimal money, ApproveChain chain) {
        beforeApprv();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doApprove(money, chain);

        afterApprv();
    }

    abstract void doApprove(BigDecimal money, ApproveChain chain);

    private long t = 0;

    void beforeApprv() {
        t = System.currentTimeMillis();
        System.out.println(t);
    }

    void afterApprv() {
        System.out.println(t);
    }

}
