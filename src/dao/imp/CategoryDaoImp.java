package dao.imp;

import dao.CategoryDao;
import domain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtil;
import utils.MyBeanUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Will.Guo
 * @create: 2018-06-13 16:02
 **/
public class CategoryDaoImp implements CategoryDao {
    @Override
    public List findAll() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from category";
        try {
            return qr.query(sql,new BeanListHandler<Category>(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
