package service.impl;

import dao.OrderDao;
import dao.imp.OrderDaoImpl;
import domain.Order;
import domain.OrderItem;
import org.apache.commons.dbutils.DbUtils;
import service.OrderService;
import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-15 16:07
 **/
public class OrderServiceImpl implements OrderService {

    OrderDao dao = new OrderDaoImpl();

    @Override
    public void save(Order order) throws SQLException {
        Connection conn = null;
        try {
            conn = JDBCUtil.getConnection();

            dao.save(conn,order);
            for (Object var : order.getList()) {
                OrderItem item = (OrderItem) var;
                dao.save(conn,item);
            }
            DbUtils.commitAndCloseQuietly(conn);
        } catch (SQLException e) {
            DbUtils.rollback(conn);
        }

    }

    @Override
    public Order findOrderBtOid(String oid) {
        return dao.findByOid(oid);
    }

    @Override
    public void updateOrderByOid(Order order) {
        dao.updateOrderByOid(order);
    }



}
