package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestConn {
    public static void main(String[] args) throws IOException {
        Connection connection = null;
        String driver = ConfManager.getInstance().getValue("driver");
        String url = ConfManager.getInstance().getValue("url");
        String username = ConfManager.getInstance().getValue("username");
        String password = ConfManager.getInstance().getValue("password");
        try {
            Class.forName(driver);
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
