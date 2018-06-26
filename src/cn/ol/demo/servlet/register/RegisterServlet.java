package cn.ol.demo.servlet.register;

import cn.ol.demo.domain.User;
import cn.ol.demo.services.UserService;
import cn.ol.demo.util.ActiveUserCodeUtil;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, request.getParameterMap());

            // 封裝激活码
            user.setActiveCode(ActiveUserCodeUtil.createActiveUserCode());

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 调用service完成注册操作。
        UserService service = new UserService();
        try {
            service.register(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 注册成功，跳转到registersuccess.jsp
        response.sendRedirect(request.getContextPath() + "/result.jsp");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
