package cn.ol.demo.services;

import cn.ol.demo.dao.UserDao;
import cn.ol.demo.domain.User;
import cn.ol.demo.util.SendMailUtils;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao = new UserDao();

    public void register(User user) throws SQLException {
//        数据库添加用户
        userDao.addUser(user);
        new SendMailUtils();
    }
}
