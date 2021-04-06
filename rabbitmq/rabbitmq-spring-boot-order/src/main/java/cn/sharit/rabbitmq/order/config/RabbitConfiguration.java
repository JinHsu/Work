package cn.sharit.rabbitmq.order.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

//    // 声明交换机
//    @Bean
//    public FanoutExchange fanoutExchange() {
//        return new FanoutExchange("fanout-order-exchange");
//    }
//
//    // 声明队列
//    @Bean
//    public Queue smsQueue() {
//        return new Queue("sms");
//    }
//
//    @Bean
//    public Queue emailQueue() {
//        return new Queue("email");
//    }
//
//    @Bean
//    public Queue noticeQueue() {
//        return new Queue("notice");
//    }
//
//    // 绑定
//    @Bean
//    public Binding smsBinding() {
//        return BindingBuilder.bind(smsQueue()).to(fanoutExchange());
//    }
//
//    @Bean
//    public Binding emailBinding() {
//        return BindingBuilder.bind(emailQueue()).to(fanoutExchange());
//    }
//
//    @Bean
//    public Binding noticeBinding() {
//        return BindingBuilder.bind(noticeQueue()).to(fanoutExchange());
//    }

}
