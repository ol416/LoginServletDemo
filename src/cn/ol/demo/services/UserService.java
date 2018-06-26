package cn.ol.demo.services;

import cn.ol.demo.dao.UserDao;
import cn.ol.demo.domain.User;
import cn.ol.demo.exception.ActiveUserException;
import cn.ol.demo.util.ActiveUserCodeUtil;
import cn.ol.demo.util.SendMailUtils;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.util.Date;

public class UserService {
    private UserDao userDao = new UserDao();

    //注册服务
    public void register(User user) throws SQLException {
//        数据库添加用户
        userDao.addUser(user);
        //发送邮件
        new SendMailUtils();
    }

    //激活码验证服务
    //需要设计一个定期清除未激活的用户的类
    public void activeUser(String activeCode) throws SQLException, ActiveUserException {
        User user = userDao.findUserByActiveCode(activeCode);
        if(user == null){
            throw new ActiveUserException("用户激活失败");
        }
        Date registerTime = user.getRegisterationTime();
        long tmpTime = System.currentTimeMillis() - registerTime.getTime();
        if (tmpTime / (1000*60*60) > 24){
            throw new ActiveUserException("激活码失效");
        }
        //修改数据库用户激活状态
        userDao.activeUser(activeCode);
    }

    //登录服务
    public User login(String username, String password) throws LoginException, SQLException {
        //获取用户信息
        User user = userDao.userValidation(username, password);
        if(user != null) {
            if (user.getState().equals("1")) {        //获取激活状态
                return user;
            }
            throw new SQLException("登录失败，用户" + user.getUsername() + "尚未被激活！");
        }
        throw new LoginException("登录失败，用户名或密码错误！");
    }
}
