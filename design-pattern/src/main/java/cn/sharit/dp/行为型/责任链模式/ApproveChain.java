package cn.sharit.dp.行为型.责任链模式;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ApproveChain {

    private final List<Handler> approves = new ArrayList<>();

    private int pos = -1;

    void approve(BigDecimal request) {
        if (++pos == approves.size()) {
            return;
        }
        Handler handler = approves.get(pos);
        handler.apprv(request, this);
    }

    public ApproveChain addHandler(Handler handler) {
        approves.add(handler);
        return this;
    }
}
