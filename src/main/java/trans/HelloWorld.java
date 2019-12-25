package trans;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "HelloWorld")
public class HelloWorld extends HttpServlet {
    private String message;

    public void init() throws ServletException {
        // 初始化
        message = "Hello, First Servlet!";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(11111);
        //获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map map = new HashMap();
        HttpSession session = request.getSession();

        //模拟到数据库查询用户名和密码，让后取得数据
        if (username != null && password != null) {
            //假定我们已经取得数据，现在是在将数据封装在map中
            map.put("username", username);
            map.put("password", password);
            map.put("age", 23);
            map.put("sex", "男");
            map.put("phone", "13566668888");

            //使用session存放userid
            session.setAttribute("userid", 5);
            //使用request存放map
            request.setAttribute("maps", map);
        } else {
            request.setAttribute("maps", null);
            session.setAttribute("userid", "");
        }

        System.out.println(11111);
        try {
            request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置:响应内容类型
        response.setContentType("text/html");

        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("<h1> " + message + " </h1>");
    }
}

