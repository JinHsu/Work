package cn.sharit.rabbitmq.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeUnit;

public class Producer {

    public static void main(String[] args) {
        String exchangeName = "work-exchange";
        String exchangeType = "fanout";
        String queueName = "q4";
        String routingKey = "";

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
            channel.queueDeclare(queueName, true, false, false, null);

            // 6.队列绑定交换机
            channel.queueBind(queueName, exchangeName, routingKey);

            // 7.发送
            for (int i = 0; i < 20; i++) {
                channel.basicPublish(exchangeName, routingKey, null, ("message" + i).getBytes());
                TimeUnit.MILLISECONDS.sleep(200);
            }

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
