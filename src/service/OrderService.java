package service;

import domain.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @description: 订单service
 * @author: Will.Guo
 * @create: 2018-06-15 16:06
 **/
public interface OrderService {
    void save(Order order) throws SQLException;

    Order findOrderBtOid(String oid);

    void updateOrderByOid(Order order);

    List findOrdersByUid(String uid);
}
