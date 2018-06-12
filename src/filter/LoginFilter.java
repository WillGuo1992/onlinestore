package filter;


import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;
import servlet.UserServlet;
import utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 自动登录过滤器
 * @author: Will.Guo
 * @create: 2018-06-13 00:42
 **/
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       HttpServletRequest request =  (HttpServletRequest) servletRequest;
       HttpServletResponse response = (HttpServletResponse) servletResponse;

        String servletPath = request.getServletPath();
        if (servletPath.contains("UserServlet") && servletPath.contains("loginUI")) {
            filterChain.doFilter(request,response);
            return;
        }
        User user= (User) request.getSession().getAttribute("user");
        if (user!=null) {
            filterChain.doFilter(request,response);
            return;
        }
        Cookie[] cookies = request.getCookies();
        Cookie cookie = CookieUtils.getCookie("autologin", cookies);
        if (cookie == null){
            filterChain.doFilter(request,response);
            return;
        }
        if (cookie != null) {
            String[] strs = cookie.getValue().split("@");
            UserService userService = new UserServiceImpl();
            User user1 = new User();
            user1.setUsername(strs[0]);
            user1.setPassword(strs[1]);
            user1 = userService.checkUserByUsernameAndPassword(user1);
            if (user1 == null){
                filterChain.doFilter(request,response);
                return;
            } else {
                request.getSession().setAttribute("user",user1);
                filterChain.doFilter(request,response);
                return;
            }
        }

    }

    @Override
    public void destroy() {

    }
}
