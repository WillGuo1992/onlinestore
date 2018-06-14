package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 是否已经登录过滤器, 防止其操作购物车和订单等
 * @author: Will.Guo
 * @create: 2018-06-14 23:52
 **/
public class HasLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Object obj = req.getSession().getAttribute("user");
        if (obj != null) {
            filterChain.doFilter(req, resp);
            return;
        } else {
            resp.sendRedirect("jsp/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
