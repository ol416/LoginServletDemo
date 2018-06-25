package cn.ol.demo.servlet.register;

import cn.ol.demo.exception.ActiveUserException;
import cn.ol.demo.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ActiveUserServlet")
public class ActiveUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取链接中的激活码部分
        String activeCode = request.getParameter("activeCode");
        //调用activeUser方法激活用户
        UserService userService = new UserService();
        try {
            userService.activeUser(activeCode);
            response.sendRedirect(request.getContextPath() + "/register/register_success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ActiveUserException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
