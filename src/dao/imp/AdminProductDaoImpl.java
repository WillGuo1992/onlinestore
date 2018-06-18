package dao.imp;

import dao.AdminProductDao;
import domain.Category;
import domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-18 23:29
 **/
public class AdminProductDaoImpl implements AdminProductDao {
    @Override
    public int findAllCount() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select count(*) from product";
        try {
            Object ret =  qr.query(sql, new ScalarHandler(1));
            return Integer.valueOf(ret.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Product> findByPage(int startIndex, int pageSize, int pflag) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where pflag = ? order by pid limit ? offset ? ";
        try {
            return qr.query(sql, new BeanListHandler<>(Product.class), pflag, pageSize, startIndex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAllCategory() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from category";
        try {
            return qr.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
