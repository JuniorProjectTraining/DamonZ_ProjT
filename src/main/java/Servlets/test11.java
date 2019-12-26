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

@WebServlet(name = "/login")
public class test11 {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("登录成功！");
        System.out.println(req.getContextPath());
        resp.sendRedirect("JSPs/main.jsp");
    }
}

