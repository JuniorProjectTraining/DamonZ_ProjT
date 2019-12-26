package Servlets;


import Classes.User;
import Classes.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "cn/damonzzz/Servlets/LogInServlet")
public class LogInServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        req.setCharacterEncoding("utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname + ":" + pwd);

        User user = new User();
        user.setName(uname);
        user.setPwd(pwd);

        UserDao ud = new UserDao();

        try {
            if (ud.SearchUserLog(user)) {

                System.out.println("登录成功！");
                System.out.println(req.getContextPath());
                resp.sendRedirect("JSPs/main.jsp");

            } else {
                resp.sendRedirect("http://localhost:8080/ServeletDemo_war_exploded2/useRegister.jsp");
                JOptionPane.showMessageDialog(null, "密码错误！");
                System.out.println("登录失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
