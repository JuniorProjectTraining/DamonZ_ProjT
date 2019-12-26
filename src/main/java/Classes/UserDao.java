package Classes;

import JDBC.JDBCutil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends User {

    public boolean SearchUserLog(User user) throws SQLException {
        boolean flag = false;
        JDBCutil util = new JDBCutil();
        Connection conn = util.getConn();
        String sql = "select * from user where name='" + user.getName() + "' and password='" + user.getPwd() + "'";
        System.out.println(sql);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            flag = true;
        }

        conn.close();
        return flag;
    }

    //���
    public boolean AddUser(User user) throws SQLException {
        boolean flag = false;

        JDBCutil util = new JDBCutil();
        Connection conn = util.getConn();
        String sql = "insert into user values('" + user.getName() + "','" + user.getPwd() + "')";
        PreparedStatement ps = conn.prepareStatement(sql);
        int line = ps.executeUpdate();
        if (line == 1) {
            flag = true;
        }

        conn.close();
        return flag;
    }
}
