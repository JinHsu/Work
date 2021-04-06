package cn.sharit.rabbitmq.order.service;

import cn.sharit.rabbitmq.order.mapper.OrderMapper;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSendConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("cause=" + cause);

        if (!ack) {
            System.out.println("交换机应答失败 orderId = " + correlationData.getId());
            return;
        }

        int count = orderMapper.updateStatus(1, Long.valueOf(correlationData.getId()));
        System.out.println(count == 1 ? "消息投递成功" : "");

    }
}
