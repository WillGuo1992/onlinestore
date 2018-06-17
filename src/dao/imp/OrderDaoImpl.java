package dao.imp;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.OrderDao;
import domain.Order;
import domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtil;

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

    @Override
    public Order findByOid(String oid) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from orders where oid = ?";
        try {
            return qr.query(sql,new BeanHandler<Order>(Order.class),  oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrderByOid(Order order) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update orders set state = 2 ,address= ? , name= ? , telephone= ? where oid = ? ";
        int update ;
        try {
            update = qr.update(sql, order.getAddress(), order.getName(), order.getTelephone(), order.getOid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
