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
        String sql = "select * from product where pflag=0 and cid = ? ";
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
        String sql = "select * from product where pflag=0 and cid = ? limit ? offset ?";
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

    @Override
    public void save(Product product) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?)";
        Object[] params = {product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(), product.getPimage(),
                product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(), product.getCid()};
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updatePflagByPid(String pid, int pflag) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update product set pflag = ? where pid = ?";
        try {
            qr.update(sql, pflag,pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findAllByPflag(int pfalg) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product  where pflag = ? ";
        try {
            return qr.query(sql, new BeanListHandler<Product>(Product.class),pfalg);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
