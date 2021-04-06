package cn.sharit.rabbitmq.stock.mapper;

import cn.sharit.rabbitmq.stock.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StockMapper {

    int insert(Stock stock);

    Stock selectById(Long id);

    Stock selectByProductId(@Param("productId") Long productId);

    int update(Stock stock);
}
