package cn.sharit.rabbitmq.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadRabbitConfiguration {

//    // 声明交换机
//    @Bean
//    public FanoutExchange deadFanoutExchange() {
//        return new FanoutExchange("dead-fanout-exchange");
//    }
//
//    // 声明队列
//    @Bean
//    public Queue deadQueue() {
//        return new Queue("dead.queue");
//    }
//
//
//    // 绑定
//    @Bean
//    public Binding deadBinding() {
//        return BindingBuilder.bind(deadQueue()).to(deadFanoutExchange());
//    }

}
