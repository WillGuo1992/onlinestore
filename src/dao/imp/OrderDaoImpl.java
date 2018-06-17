package dao.imp;

import dao.OrderDao;
import domain.Order;
import domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-15 16:08
 **/
public class OrderDaoImpl implements OrderDao {

    @Override
    public void save(Connection conn, Order order) {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        Object[] objs = {order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(),
                order.getName(), order.getTelephone(), order.getUser().getUid()};
        try {
            queryRunner.update(conn, sql, objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(Connection conn, OrderItem item) {
        QueryRunner qr = new QueryRunner();
        String sql = "insert into orderitem values(?,?,?,?,?)";
        Object[] objects = {item.getItemid(), item.getCount(), item.getSubtotal(), item.getProduct().getPid(), item.getOrder().getOid()};
        try {
            qr.update(conn, sql, objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
