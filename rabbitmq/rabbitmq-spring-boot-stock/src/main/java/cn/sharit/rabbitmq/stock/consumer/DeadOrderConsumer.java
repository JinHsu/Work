package cn.sharit.rabbitmq.stock.consumer;

import cn.sharit.rabbitmq.stock.pojo.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * 监听死信队列
 */
@Component
@RabbitListener(queues = {"dead.order.queue"})
public class DeadOrderConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    private int count = 0;

    @RabbitHandler
    public void handle(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {
        try {
            System.out.println("接受到 message=" + message);
            count++;
            System.out.println("count=" + count);
            Order order = objectMapper.readValue(message, Order.class);
            System.out.println(order);
            channel.basicAck(tag, false);
        } catch (Exception e) {
//            channel.basicNack(tag, false, false);
            System.out.println("人工干预");
            System.out.println("发短信预警");
            System.out.println("持久化到数据库");
        }
    }

}
