package cn.sharit.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

    public static void main(String[] args) {
        String exchangeName = "fanout-exchange";
        String exchangeType = "fanout";
        String routingKey = "";
        String queueName1 = "q1";
        String queueName2 = "q2";
        String queueName3 = "q3";
        String message = "Hello, RabbitMQ";
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
            connection = connectionFactory.newConnection("生产者");
            // 3.创建通道
            channel = connection.createChannel();

            // 4.声明交换机
            channel.exchangeDeclare(exchangeName, exchangeType, true);

            // 5.声明队列
            channel.queueDeclare(queueName1, true, false, false, null);
            channel.queueDeclare(queueName2, true, false, false, null);
            channel.queueDeclare(queueName3, true, false, false, null);

            // 6.队列绑定交换机
            channel.queueBind(queueName1, exchangeName, routingKey);
            channel.queueBind(queueName2, exchangeName, routingKey);
            channel.queueBind(queueName3, exchangeName, routingKey);

            // 7.发送
            channel.basicPublish(exchangeName, routingKey, null, message.getBytes());

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
