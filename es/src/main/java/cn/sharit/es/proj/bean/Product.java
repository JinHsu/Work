package cn.sharit.es.proj.bean;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mall", indexStoreType = "product")
public class Product {

    @Id // 必须
    private String id;
    private String productName;
    private String productPrice;
    private String productImg;

    public Product() {
    }

    public Product(String id, String productName, String productPrice, String productImg) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImg = productImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
