package cn.sharit.rabbitmq.stock.service;

import cn.sharit.rabbitmq.stock.mapper.StockMapper;
import cn.sharit.rabbitmq.stock.pojo.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 库存服务
 */
@Service
public class StockService {

    @Autowired
    private StockMapper stockMapper;

    // 减库存
    public int decrease(@PathVariable Long productId, @PathVariable int inventory) {
        Stock stock = stockMapper.selectByProductId(productId);
        if (stock == null) {
            throw new RuntimeException("商品不存在!");
        }

        if (stock.getInventory() < inventory) {
            throw new RuntimeException("库存不足!");
        }

        stock.setInventory(stock.getInventory() - inventory);

        return stockMapper.update(stock);

    }
}
