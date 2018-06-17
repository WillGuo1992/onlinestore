package dao;

import domain.Order;
import domain.OrderItem;

import java.sql.Connection;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-15 16:08
 **/
public interface OrderDao {
    void save( Connection conn,Order order);

    void save(Connection conn,OrderItem item);
}
