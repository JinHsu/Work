package cn.sharit.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Consumer {

    public static void main(String[] args) {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.188");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");

        String queueName = "queue1";
        Connection connection = null;
        Channel channel = null;
        try {
            // 1.创建连接
            connection = connectionFactory.newConnection("消费者");
            // 2.创建通道
            channel = connection.createChannel();

            // 3.消费消息
            channel.basicConsume(queueName, true, (s, delivery) -> {
                System.out.println("接收到消息=" + new String(delivery.getBody(), StandardCharsets.UTF_8));
            }, s -> {
                System.out.println("接收消息失败");
            });

            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4.关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception e) {
                }
            }
            // 5.关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
