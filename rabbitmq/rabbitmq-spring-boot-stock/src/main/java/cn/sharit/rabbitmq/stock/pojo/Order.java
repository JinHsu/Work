package cn.sharit.rabbitmq.stock.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单实体
 */
public class Order implements Serializable {

    private long id; // 主键
    private String title; // 订单标题
    private Date date; // 下单时间
    private Double price; // 下单金额
    private Long productId; // 商品id;
    private int num; // 商品数量
    private int status; // 订单的状态： 0初始状态，1下单成功状态

    // ...
    public Order() {
    }

    public Order(long id, String title, Date date, Double price, Long productId, int num) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.price = price;
        this.productId = productId;
        this.num = num;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
