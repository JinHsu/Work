package cn.sharit.rabbitmq.order.service;

import cn.sharit.rabbitmq.order.mapper.OrderMapper;
import cn.sharit.rabbitmq.order.pojo.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * 订单服务
 */
@Service
public class OrderService implements InitializingBean {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderSendConfirmCallback orderSendConfirmCallback;

    /**
     * 下单
     */
    public void makeOrder() {
        // 查询库存

        // 保存订单
        Order order = new Order(0, "", new Date(), 200.0, 101L, 3);
        Order order1 = saveOrder(order);

        dispatch(order1);


    }

    public void makeOrderWithMessage() {
        // 查询库存

        // 保存订单
        Long maxOrderId = orderMapper.selectMaxOrderId();
        Order order = new Order(maxOrderId == null ? 0 : maxOrderId + 1, "", new Date(), 200.0, 101L, 3);
        Order order1 = saveOrder(order);

        // 发送减库存消息
        sendMessage(order1);
    }


    public void sendMessage(Order order) {
        String exchangeName = "order-exchange";
        String routingKey = "";
        try {
            String message = objectMapper.writeValueAsString(order);
            rabbitTemplate.convertAndSend(exchangeName, routingKey, message,
                    new CorrelationData(order.getId() + ""));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Order saveOrder(Order order) {
        orderMapper.insert(order);
        return orderMapper.selectById(order.getId());
    }

    public int dispatch(Order order) {
        String url = "http://localhost:7777/stock/decrease/" + order.getProductId() + "/" + order.getNum();
        ResponseEntity<Integer> entity = null;
        try {
            entity = restTemplate.postForEntity(new URI(url), null, Integer.class);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (entity == null || entity.getBody() != 1) {
            throw new RuntimeException("减库存失败!");
        }
        return entity.getBody();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        rabbitTemplate.setConfirmCallback(orderSendConfirmCallback);
    }
}
