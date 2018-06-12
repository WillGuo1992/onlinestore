package service.impl;

import dao.UserDao;
import dao.imp.UserDaoImp;
import domain.User;
import service.UserService;
import utils.MailUtils;

/**
 * @description: 用户模块Service实现类
 * @author: Will.Guo
 * @create: 2018-06-10 18:17
 **/
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImp();
    @Override
    public void register(User user) {
        userDao.save(user);
        //send email
        try {
            MailUtils.sendEmail(user.getCode(), user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUserByUsername(User user) {
        User user2 = userDao.findUserByUsername(user);
        if (user2 != null) {
            return true;
        }
        return false;
    }

    @Override
    public User checkUserByUsernameAndPassword(User user) {
        return userDao.findUserByUsernameAndPassword(user);
    }

    @Override
    public void active(User user) {
        userDao.UpdateUserByCode(user);
    }
}
