package cn.ol.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 处理请求乱码
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletRequest myRequest = new MyRequest(httpServletRequest);

        // 处理响应乱码
        resp.setContentType("text/html;charset=utf-8");
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
