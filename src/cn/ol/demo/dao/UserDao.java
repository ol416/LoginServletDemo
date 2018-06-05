package cn.ol.demo.dao;

import cn.ol.demo.domain.User;
import cn.ol.demo.util.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.SQLException;

public class UserDao {
     DataSource getDataSource = DataSourceUtils.getDataSource();

     //    添加用户
    public void addUser(User user) throws SQLException {
        String sql = "insert into user(username, password, gender, telephone, email, introduction, activecode) values(?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(getDataSource);
        int row = runner.update(sql, user.getUsername(), user.getPassword(), user.getGender(), user.getTelephone(), user.getEmail(), user.getIntroduction(), user.getActiveCode());
        if(row == 0){
            throw new RuntimeException();
        }
    }

    //  通过激活码查找用户
    public User findUserByActiveCode(String activeCode)throws SQLException{
        String sql = "select * from user where activecode=?";
        QueryRunner runner = new QueryRunner(getDataSource);
        return runner.query(sql,new BeanHandler<User>(User.class),activeCode);
    }

    //激活用户
    public void activeUser(String activeCode) throws SQLException {
        String sql = "update user set state=? where activecode=?";
        QueryRunner runner = new QueryRunner(getDataSource);
        runner.update(sql, 1, activeCode);
    }

    //登录验证
    public User userValidation(String username, String password) throws SQLException {
        String sql="select * from user where username=? and password=?";
        QueryRunner runner = new QueryRunner(getDataSource);
        return runner.query(sql, new BeanHandler<User>(User.class), username, password);
    }
}
