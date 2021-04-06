package cn.sharit.rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

    public static void main(String[] args) {
        // 1.创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.1.188");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");

        String queueName = "queue1";
        String message = "Hello, RabbitMQ";
        Connection connection = null;
        Channel channel = null;
        try {
            // 2.创建连接
            connection = connectionFactory.newConnection("生产者");
            // 3.创建通道
            channel = connection.createChannel();

            /**
             *
             */
            // 4.创建交换机
            channel.queueDeclare(queueName, true, false, false, null);

            // 5.发送
            channel.basicPublish("", queueName, null, message.getBytes());

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
