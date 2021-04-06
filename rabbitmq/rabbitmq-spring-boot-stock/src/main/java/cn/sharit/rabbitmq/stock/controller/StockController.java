package cn.sharit.rabbitmq.stock.controller;

import cn.sharit.rabbitmq.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/stock/decrease/{productId}/{inventory}")
    public int decrease(@PathVariable Long productId, @PathVariable int inventory) {
        return stockService.decrease(productId, inventory);
    }

}
