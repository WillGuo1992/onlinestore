package servlet;

import domain.Category;
import net.sf.json.JSONArray;
import service.CategoryService;
import service.impl.CategoryServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    public String getcategories(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CategoryService categoryService = new CategoryServiceImp();
        List categories = categoryService.findall();
        String jsonStr = JSONArray.fromObject(categories).toString();
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonStr);
        return null;
    }
}
