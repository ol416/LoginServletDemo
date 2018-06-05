package cn.ol.demo.login;

import cn.ol.demo.util.MySqlTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/loginServlet"})
/**
 * Servlet implementation class hh
 */
public class LoginServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");

        String password = req.getParameter("password");

        String validationCode = req.getParameter("validateCode");

        HttpSession session = req.getSession();

        String validation_code = (String)session.getAttribute("validation_code");

        if(validationCode.equalsIgnoreCase(validation_code)){

            session.setAttribute("code","验证码正确");

        }else{

            session.setAttribute("code", "验证码错误");

        }

        MySqlTest mss = new MySqlTest();

        String result = mss.checkUser(username,password);

        if (result.equals("hasUserNameAndPasswordCorrect")) {

            session.setAttribute("login", "用户名和密码均正确");

        } else if (result.equals("hasUserNameButPasswordInCorrect")) {

            session.setAttribute("login","用户名正确,密码不正确");

        } else if (result.equals("hasNoUserName")) {

            session.setAttribute("login","没有此用户");

        }

        //转发到result.jsp

        RequestDispatcher rd = req.getRequestDispatcher("result.jsp");

        rd.forward(req, resp);
        session.removeAttribute("validation_code");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}
