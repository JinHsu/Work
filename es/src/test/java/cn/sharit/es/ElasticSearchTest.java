package cn.sharit.es;

import cn.sharit.es.bean.User;
import cn.sharit.es.proj.bean.Product;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ElasticSearchTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void contextLoads() {
        System.out.println(client);
    }

    //创建index
    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("user_db");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        String index = response.index();
        assert "user_db".equals(index);
    }

    // 获取index
    @Test
    public void findIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("user_db");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        assert exists;
    }

    // 删除index
    @Test
    public void deleteIndex() throws Exception {
        DeleteIndexRequest request = new DeleteIndexRequest("user_db");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        assert response.isAcknowledged();
    }

    // 创建文档
    @Test
    public void createDoc() throws Exception {
        User user = new User("1", "徐进", 20, "备注");
        IndexRequest indexRequest = new IndexRequest("user_db")
                .id("1")
                .timeout("1s")
                .source(JSON.toJSONString(user), XContentType.JSON);

        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);

        assert "1".equals(response.getId());

    }

    //  获取文档
    @Test
    public void getDoc() throws IOException {
        GetRequest request = new GetRequest("user_db", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        assert response.isExists();
    }

    // 更新文档
    @Test
    public void updateDoc() throws IOException {
        User user = new User("1", "徐进", 22, "备注");
        UpdateRequest request = new UpdateRequest("user_db", "1");
        request
                .timeout("1s")
                .doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response.getVersion());

    }

    // 删除文档
    @Test
    public void deleteDoc() throws IOException {
        DeleteRequest request = new DeleteRequest("user_db", "1");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    // 批量添加数据
    @Test
    public void batchCreate() throws IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User("2", "徐进2", 11, "备注2"));
        userList.add(new User("3", "徐进3", 33, "备注3"));
        userList.add(new User("4", "徐进4", 44, "备注4"));
        userList.add(new User("5", "徐进5", 55, "备注5"));

        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 0; i < userList.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("user_db").id((i + 2) + "").source(JSON.toJSONString(userList.get(i)), XContentType.JSON)
            );
        }

        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(response);
    }

    // 搜索
    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("user_db");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "徐进");
        searchSourceBuilder.query(termQueryBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(Arrays.toString(searchResponse.getHits().getHits()));
    }

    // 爬取jd商品数据
    @Test
    public void parse() throws Exception {
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

            list.add(new Product("", name, price, img));
        }

        //
        BulkRequest bulkRequest = new BulkRequest();
        for (int i = 0; i < list.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("product").id(i + "").source(JSON.toJSONString(list.get(i)), XContentType.JSON)
            );
        }

        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);

    }

}
