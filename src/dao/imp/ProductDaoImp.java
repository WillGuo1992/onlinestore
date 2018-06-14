package dao.imp;

import dao.ProductDao;
import domain.Category;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-13 21:02
 **/
public class ProductDaoImp implements ProductDao {
    @Override
    public List findhot() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where is_hot=1 and pflag = 0 limit 9 offset 0";
        try {
            return qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List findnew() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where pflag = 0 order by pdate desc limit 9 offset 0";
        try {
            return qr.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product findbyid(String pid) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where pid = ?";
        try {
            return qr.query(sql, new BeanHandler<Product>(Product.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findCategorybyid(String pid) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product,category  where product.pid = ? and category.cid = product.cid";
        try {
            return qr.query(sql, new BeanHandler<Category>(Category.class),pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List findProductsByCid(String cid) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where cid = ? ";
        try {
            return qr.query(sql, new BeanListHandler<Product>(Product.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List findPageByCid(String cid, int startIndex, int pageSize) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where cid = ? limit ? offset ?";
        try {
            return qr.query(sql, new BeanListHandler<Product>(Product.class),cid,pageSize,startIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Category findCategoryByCid(String cid) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from category  where cid = ? ";
        try {
            return qr.query(sql, new BeanHandler<Category>(Category.class),cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
