package cn.sharit.rabbitmq.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLRabbitConfiguration {

//    // 声明交换机
//    @Bean
//    public FanoutExchange ttlFanoutExchange() {
//        return new FanoutExchange("ttl-fanout-order-exchange");
//    }
//
//    // 声明队列
//    @Bean
//    public Queue ttlSmsQueue() {
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-message-ttl", 5000); // TTL：5s // 队列TTL
//        args.put("x-dead-letter-exchange", "dead-fanout-exchange"); // 指定死信队列交换机
//        return new Queue("ttl.sms", true, false, false, args);
//    }
//
//    // 绑定
//    @Bean
//    public Binding ttlSmsBinding() {
//        return BindingBuilder.bind(ttlSmsQueue()).to(ttlFanoutExchange());
//    }

}
