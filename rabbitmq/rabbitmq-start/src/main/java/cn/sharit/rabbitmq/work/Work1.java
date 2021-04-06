package cn.sharit.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Work1 {

    public static void main(String[] args) {
        String queueName = "q4";
        Connection connection = null;
        Channel channel = null;
        try {
            // 1.创建连接工厂
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("192.168.1.188");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
            connectionFactory.setVirtualHost("/");

            // 2.创建连接
            connection = connectionFactory.newConnection("消费者");
            // 3.创建通道
            channel = connection.createChannel();

            // 4.消费消息
            channel.basicConsume(queueName, true, (s, delivery) -> {
                System.out.println("Work1 接收到消息=" + new String(delivery.getBody(), StandardCharsets.UTF_8));
            }, s -> {
                System.out.println("Work1 接收消息失败");
            });
            int read = System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭通道
            if (channel != null && channel.isOpen()) {
                try {
                    channel.close();
                } catch (Exception e) {
                }
            }
            // 关闭连接
            if (connection != null && connection.isOpen()) {
                try {
                    connection.close();
                } catch (Exception e) {
                }
            }
        }
    }
}
