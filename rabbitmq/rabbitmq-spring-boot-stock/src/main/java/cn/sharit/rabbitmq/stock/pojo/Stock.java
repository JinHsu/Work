package cn.sharit.rabbitmq.stock.pojo;

import java.io.Serializable;

public class Stock implements Serializable {

    private Long id;
    private Long productId; // 商品id
    private int inventory; // 库存量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
