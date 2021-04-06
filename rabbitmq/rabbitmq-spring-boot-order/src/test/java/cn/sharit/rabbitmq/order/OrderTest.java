package cn.sharit.rabbitmq.order;

import cn.sharit.rabbitmq.order.service.OrderService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public void order() {
        orderService.makeOrder();

    }

    @Test
    public void order2() throws IOException {
        orderService.makeOrderWithMessage();
        System.in.read();
    }

}
