package cn.sharit.dp.行为型.责任链模式;

import java.math.BigDecimal;

/**
 * 责任链模式
 */
public class ResponsbilityChainDemo {

    public static void main(String[] args) {
        /*
         * 项目报销审批流程问题：
         * 1）提交给专业主任审批
         * 2）金额大于5000需要学院院长审批
         * 3）金额大于10000需要副校长审批
         * 4）金额大于30000需要校长审批
         */
        ApproveChain approveChain = new ApproveChain(); // 审批流程链
        approveChain
                .addHandler(new ZhuRenHandler())
                .addHandler(new YuanZhangHandler())
                .addHandler(new FuXiaoZhangHandler())
                .addHandler(new XiaoZhangHandler());

        approveChain.approve(BigDecimal.valueOf(50000));
    }
}
