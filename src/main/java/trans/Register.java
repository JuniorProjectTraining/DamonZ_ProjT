package trans;

import cn.damonzzz.User;
import cn.damonzzz.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "Register")
public class Register extends HttpServlet {

   /* static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/blacklotus";//dudu数据库名称

    //数据库用户名和密码
    static final String USER="root";
    static final String PASS="zycfs0827";*/
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // response.sendRedirect("main.jsp");//重定向到new.jsp
    //doGet(request, response);
    // }

    public void init() throws ServletException {
        // Put your code here
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //������Ӧ�����ʽ
        resp.setContentType("text/html;charset=utf-8");
        //������������ʽ
        req.setCharacterEncoding("utf-8");
        //��ȡ������Ϣ
        String username = req.getParameter("uid");
        String userpwd = req.getParameter("password");
        String userrpwd = req.getParameter("confirmPassword");
        System.out.println(username + ":" + userpwd + ":" + userrpwd);//��̨��ʾ������Ϣ

        User user = new User();
        user.setName(username);
        UserDao ud = new UserDao();
        try {
            if (userpwd.equals(userrpwd)) {
                user.setPwd(userpwd);
                if (ud.AddUser(user)) {
                    JOptionPane.showMessageDialog(null, "注册成功");
                    resp.sendRedirect("http://localhost:8080/ServeletDemo_war_exploded2/useRegister.jsp");
                    System.out.println("注册成功！");
                } else {
                    System.out.println("请核对密码！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "注册失败");
                resp.sendRedirect("http://localhost:8080/ServeletDemo_war_exploded2/useRegister.jsp");
                System.out.println("���벻һ�£�");
            }
        } catch (SQLException e) {
            // TODO �Զ����ɵ� catch ��
            e.printStackTrace();
        }
    }
}

