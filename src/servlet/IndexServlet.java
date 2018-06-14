package servlet;

import domain.Category;
import domain.Product;
import net.sf.json.JSONArray;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImp;
import service.impl.ProductServiceImp;
import utils.JedisUtils;

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
        ProductService productService = new ProductServiceImp();
        List hotProducts =  productService.findhot();
        List newProducts = productService.findnew();
        req.setAttribute("hotProducts",hotProducts);
        req.setAttribute("newProducts",newProducts);
        return "jsp/index.jsp";
    }

    public String getcategoriesUsingRedis(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        jsonStr = JedisUtils.getString("categories");
        if (jsonStr == null) {
            CategoryService categoryService = new CategoryServiceImp();
            List categories = categoryService.findall();
            jsonStr = JSONArray.fromObject(categories).toString();
            JedisUtils.setString("categories",jsonStr,10);
        }
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonStr);
        return null;
    }

    public String getcategories(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonStr = null;
        CategoryService categoryService = new CategoryServiceImp();
        List categories = categoryService.findall();
        jsonStr = JSONArray.fromObject(categories).toString();

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonStr);
        return null;
    }
}
