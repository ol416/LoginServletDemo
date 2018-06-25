package cn.ol.demo.servlet.login;

import cn.ol.demo.domain.User;
import cn.ol.demo.services.UserService;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/loginServlet"})
/**
 * Servlet implementation class hh
 */
public class LoginServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取登录页面输入的用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.调用service完成登录操作。
        UserService service = new UserService();
        try {
            User user = service.login(username, password);

            // 3.登录成功，将用户存储到session中.
            request.getSession().setAttribute("user", user);
            // 获取用户的角色，其中用户的角色分普通用户和超级用户两种
            String role = user.getRole();
            // 如果是超级用户，就进入到网上书城的后台管理系统；否则进入我的账户页面
            if ("超级用户".equals(role)) {
                response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
                return;
            } else {
                response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
                return;
            }
        } catch (LoginException e) {
            // 如果出现问题，将错误信息存储到request范围，并跳转回登录页面显示错误信息
            e.printStackTrace();
            request.setAttribute("register_message", e.getMessage());
            request.getRequestDispatcher("Login.jsp").forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
