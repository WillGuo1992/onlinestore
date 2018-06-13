package servlet;

import domain.Category;
import domain.Product;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;
import service.ProductService;
import service.impl.ProductServiceImp;
import utils.MyBeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 商品servlet
 * @author: Will.Guo
 * @create: 2018-06-13 21:25
 **/
public class ProductServlet extends BaseServlet {
    public String findbyid(HttpServletRequest req, HttpServletResponse response) {
        Product product = MyBeanUtils.populate(Product.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        product = productService.findbyid(product.getPid());
        req.setAttribute("product", product);
        return "jsp/product_info.jsp";
    }


    public String getCnamebyPid(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Product product = MyBeanUtils.populate(Product.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        Category category = productService.getCategorybyPid(product.getPid());
        String jsonStr = JSONObject.fromObject(category).toString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonStr);
        return null;
    }
}