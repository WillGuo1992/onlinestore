package dao.imp;

import dao.UserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description: 用户模块实现类
 * @author: Will.Guo
 * @create: 2018-06-10 18:15
 **/
public class UserDaoImp implements UserDao {
    @Override
    public void save(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
                    user.getName(), user.getEmail(), user.getTelephone(),
                    user.getBirthday(), user.getSex(), user.getState(), user.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserByUsername(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from user where username=?";
        User user1 = null;
        try {
            user1 = qr.query(sql, new BeanHandler<User>(User.class), user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public User findUserByUsernameAndPassword(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user1 = null;
        try {
            user1 = qr.query(sql, new BeanHandler<User>(User.class), user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user1;
    }

    @Override
    public void UpdateUserByCode(User user) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "update user set  state=1 and code='' where code = ?";
        User user1 = null;
        try {
            qr.update(sql, user.getCode());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
