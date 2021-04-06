package cn.sharit.rabbitmq.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

    public static void main(String[] args) {
        String exchangeName = "direct-exchange";
        String exchangeType = "direct";
        String routingKey = "email";
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

            // 6.队列绑定交换机 路由key
            channel.queueBind(queueName1, exchangeName, "sms");
            channel.queueBind(queueName2, exchangeName, "email");
            channel.queueBind(queueName3, exchangeName, "notice");
            channel.queueBind(queueName3, exchangeName, "email");

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
