package dao;

import domain.Order;
import domain.OrderItem;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-15 16:08
 **/
public interface OrderDao {
    void save( Connection conn,Order order);

    void save(Connection conn,OrderItem item);

    Order findByOid(String oid);

    void updateOrderByOid(Order order);

    List findByUid(String uid) throws SQLException, InvocationTargetException, IllegalAccessException;
}
