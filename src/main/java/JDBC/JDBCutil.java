package JDBC;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCutil {
    private Connection conn;  //连接数据库
    private PreparedStatement prepar;  //用于接收预处理语句并进行相应的处理
    private ResultSet result;   //结果集
    private Statement state;        //用于处理一条静态的sql语句并且进行相应的处理

    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    static  /*  在静态块里面的内容会在程序找到函数的主入口之前提前读取，因此数据库的密码和用户名以及驱动之类的东西会提前预备好  */
    {
        Properties proper=new Properties();

        try {
            proper.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties"));
            driver=proper.getProperty("driver");
            url=proper.getProperty("url");
            user=proper.getProperty("user");
            password=proper.getProperty("password");
            System.out.println(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public JDBCutil() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        try {
            System.out.println("数据库连接成功");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
