package cn.sharit.rabbitmq.stock.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"sms"})
@Component
public class SmsFanoutConsumer {

    @RabbitHandler
    public void handle(String message) {
        System.out.println("接受到sms=" + message);
    }

}
