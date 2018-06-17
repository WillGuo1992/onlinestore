package service;

import domain.Order;

import java.sql.SQLException;

/**
 * @description: 订单service
 * @author: Will.Guo
 * @create: 2018-06-15 16:06
 **/
public interface OrderService {
    void save(Order order) throws SQLException;
}
