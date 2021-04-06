package cn.sharit.rabbitmq.order.mapper;

import cn.sharit.rabbitmq.order.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    int insert(Order order);

    Order selectById(Long id);

    Long selectMaxOrderId();

    int updateStatus(@Param("status") int status, @Param("id") Long id);
}
