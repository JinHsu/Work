package cn.sharit.rabbitmq.stock.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"notice"})
@Component
public class NoticeFanoutConsumer {

    @RabbitHandler
    public void handle(String message) {
        System.out.println("接受到Notice=" + message);
    }

}
