package dao.imp;

import dao.AdminCategoryDao;
import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-18 15:35
 **/
public class AdminCategoryDaoImpl implements AdminCategoryDao {
    @Override
    public List<Category> findAll() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from category";
        try {
            return qr.query(sql, new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(Category category) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into category(cid,cname) values (?,?)";
        try {
            qr.update(sql, category.getCid(), category.getCname());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category findByCname(String cname) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from category where cname = ?";
        try {
            return qr.query(sql, new BeanHandler<Category>(Category.class),cname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Category category) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update category set cname=? where cid =?";
        try {
            qr.update(sql, category.getCname(), category.getCid());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteByCname(String cname) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "delete from category where cname=?";
        try {
            qr.update(sql, cname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
