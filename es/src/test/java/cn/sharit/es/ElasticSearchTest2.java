package cn.sharit.es;

import cn.sharit.es.proj.bean.Product;
import cn.sharit.es.proj.repository.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class ElasticSearchTest2 {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void test() throws Exception {
        assert productRepository != null;

        String keyword = "java";
        String url = "https://search.jd.com/Search?keyword=" + keyword + "&enc=utf-8";
        Document document = Jsoup.parse(new URL(url), 60000);

        Element goodsList = document.getElementById("J_goodsList");

        Elements elements = goodsList.getElementsByTag("li");

        List<Product> list = new ArrayList<>();
        for (Element element : elements) {
            String img = element.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String name = element.getElementsByClass("p-name").eq(0).text();

            list.add(new Product(UUID.randomUUID().toString().substring(24), name, price, img));
        }


        productRepository.saveAll(list);
    }
}
