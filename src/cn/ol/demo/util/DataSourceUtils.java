package cn.ol.demo.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static DataSource getDataSource(){
        return dataSource;
    }

//  当DBUtils需要控制事物时，可调用此方法从连接池中获取一个空闲连接
    public static Connection getConnection() throws SQLException{
        Connection connection = threadLocal.get();
        if (connection == null){
            connection = dataSource.getConnection();
            threadLocal.set(connection);
        }
        return connection;
    }

//  开启事务，取消自动提交
    public static void startTransaction() throws SQLException {
        Connection connection = getConnection();
        if(connection != null){
            connection.setAutoCommit(false);
        }
    }

//    从线程本地存储中释放并且关闭Connection，然后结束事务
    public static void commitAndCloseConnection() throws SQLException {
        Connection connection = getConnection();
        if(connection != null){
            connection.commit();
            threadLocal.remove();
            connection.close();
        }
    }

//    回滚事务
    public static void rollback() throws SQLException{
        Connection connection = getConnection();
        if(connection != null){
            connection.rollback();
        }
    }
}
