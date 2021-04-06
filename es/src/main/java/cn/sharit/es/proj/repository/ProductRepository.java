package cn.sharit.es.proj.repository;

import cn.sharit.es.proj.bean.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
}
