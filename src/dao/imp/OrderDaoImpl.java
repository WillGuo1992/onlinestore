package dao.imp;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.OrderDao;
import domain.Order;
import domain.OrderItem;
import domain.Product;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import utils.JDBCUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        String sql = "update orders set state = ? ,address= ? , name= ? , telephone= ? where oid = ? ";
        int update ;
        try {
            update = qr.update(sql, order.getState(),order.getAddress(), order.getName(), order.getTelephone(), order.getOid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findByUid(String uid) throws SQLException, InvocationTargetException, IllegalAccessException {
        String sql="select * from orders where uid=?";
        QueryRunner qr=new QueryRunner(JDBCUtil.getDataSource());
        List<Order> list=qr.query(sql, new BeanListHandler<Order>(Order.class),uid);
        //遍历所有订单
        for (Order order : list) {
            //获取到每笔订单oid   查询每笔订单下的订单项以及订单项对应的商品信息
            String oid=order.getOid();
            sql="select * from orderItem o ,product p where o.pid=p.pid and oid=?";
            List<Map<String, Object>> list02 = qr.query(sql, new MapListHandler(),oid);
            //遍历list
            for (Map<String, Object> map : list02) {
                OrderItem orderItem=new OrderItem();
                Product product=new Product();
                // 由于BeanUtils将字符串"1992-3-3"向user对象的setBithday();方法传递参数有问题,手动向BeanUtils注册一个时间类型转换器
                // 1_创建时间类型的转换器
                DateConverter dt = new DateConverter();
                // 2_设置转换的格式
                dt.setPattern("yyyy-MM-dd");
                // 3_注册转换器
                ConvertUtils.register(dt, java.util.Date.class);

                //将map中属于orderItem的数据自动填充到orderItem对象上
                BeanUtils.populate(orderItem, map);
                //将map中属于product的数据自动填充到product对象上
                BeanUtils.populate(product, map);
                if (map.containsKey("quantity") && map.containsKey("total")) {
                    int quantity =(Integer) map.get("quantity");
                    orderItem.setCount(quantity);
                    double subtotal =(Double) map.get("total");
                    orderItem.setSubtotal(subtotal);
                }
                //让每个订单项和商品发生关联关系
                orderItem.setProduct(product);
                //将每个订单项存入订单下的集合中
                order.getList().add(orderItem);

            }
        }
        return list;
    }
}
