package cn.ol.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlTest {

    //数据库的驱动名

    private final String dbDriver = "com.mysql.jdbc.Driver";

    //数据库的url地址

    private final String url = "jdbc:mysql://127.0.0.1:3306/cool_files?useSSL=false";

    private final String userName = "root";

    private final String password = "123456";

    private Connection conn = null;

    public MySqlTest(){

        //加载数据库驱动

        try {

            Class.forName(dbDriver).newInstance();

            //System.out.println("加载驱动成功");

        } catch (Exception e) {

            e.printStackTrace();

            System.err.println("数据库驱动加载失败");

        }

        //获取数据库链接

        try {

            conn = DriverManager.getConnection(url,userName,password);

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

            System.err.println("获取数据库链接失败");

        }

    }

    //执行各种SQL语句的方法

    private ResultSet execSQL(String sql,Object... args) throws SQLException{

        //建立PreparedStatement对象

        PreparedStatement pStmt = conn.prepareStatement(sql);

        //为pStmt对象设置SQL参数值

        for(int i = 0; i < args.length; i++){

            pStmt.setObject(i+1, args[i]);

        }

        //执行SQL语句

        pStmt.execute();

        //返回结果集,如果执行的SQL语句不返回结果集，则返回null

        return pStmt.getResultSet();

    }

    private void closeSQLConn(){

        //关闭数据库链接

        if(conn != null){

            try {

                conn.close();

            } catch (SQLException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

        }

    }

    public String checkUser(String username,String password){

        boolean has_username = false;

        boolean password_correct = false;

        ResultSet rs = null;

        try {

            rs = execSQL("select * from users");

        } catch (SQLException e) {

            System.err.println("查询数据库出错");

            e.printStackTrace();

            return null;

        }

        try {

            while(rs.next()){

                String temp_username = rs.getString("user_name").trim();

                String temp_password = rs.getString("password_md5").trim();

                if(username.equals(temp_username)){

                    has_username = true;

                    if(password.equals(temp_password)){

                        password_correct = true;

                        return "hasUserNameAndPasswordCorrect";

                    }

                    return "hasUserNameButPasswordInCorrect";

                }

            }

        } catch (SQLException e) {

            System.err.println("操作ResultSet出错");

            e.printStackTrace();

        }

        return "hasNoUserName";

    }

}
