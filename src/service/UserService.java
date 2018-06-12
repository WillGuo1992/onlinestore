package service;

import domain.User;

/**
 * @description: 用户模块Service接口
 * @author: Will.Guo
 * @create: 2018-06-10 21:28
 **/
public interface UserService {
    public void register(User user) ;

    boolean checkUserByUsername(User user);

    User checkUserByUsernameAndPassword(User user);

    void active(User user);
}
