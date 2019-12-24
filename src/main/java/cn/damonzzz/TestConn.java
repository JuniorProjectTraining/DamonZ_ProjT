package cn.damonzzz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConn {
    public static void main(String[] args) {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/hellomaven";
        String username = "root";
        String password = "zycfs0827";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();

            connection = DriverManager.getConnection(url,username,password);

            long end = System.currentTimeMillis();
            System.out.println(connection);
            System.out.println("total time spend:"+(end - start)+"ms");



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
