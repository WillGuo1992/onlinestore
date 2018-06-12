package dao;

import domain.User;

/**
 * @description: 用户模块接口
 * @author: Will.Guo
 * @create: 2018-06-10 18:14
 **/
public interface UserDao {


    void save(User user);

    User findUserByUsername(User user);

    User findUserByUsernameAndPassword(User user);

    void UpdateUserByCode(User user);
}
