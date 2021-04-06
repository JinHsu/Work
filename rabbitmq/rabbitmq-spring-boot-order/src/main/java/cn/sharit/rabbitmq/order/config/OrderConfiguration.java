package cn.sharit.rabbitmq.order.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class OrderConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }


    // 声明交换机
    @Bean
    public FanoutExchange orderExchange() {
        return new FanoutExchange("order-exchange");
    }

    @Bean
    public FanoutExchange deadOrderExchange() {
        return new FanoutExchange("dead-order-exchange");
    }

    // 声明队列
    @Bean
    public Queue orderQueue() {
        Map<String, Object> args = new HashMap<>();
//        args.put("x-message-ttl", 5000); // TTL：5s // 队列TTL
        args.put("x-dead-letter-exchange", "dead-order-exchange"); // 指定死信队列交换机
        return new Queue("order.queue", false, false, false, args);
    }

    @Bean
    public Queue deadOrderQueue() {
        return new Queue("dead.order.queue");
    }

    // 绑定
    @Bean
    public Binding orderBinding() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange());
    }

    @Bean
    public Binding deadOrderBinding() {
        return BindingBuilder.bind(deadOrderQueue()).to(deadOrderExchange());
    }
}
