package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 首页servlet
 * @author: Will.Guo
 * @create: 2018-06-10 18:03
 **/
public class IndexServlet extends BaseServlet {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "jsp/index.jsp";
    }
}
