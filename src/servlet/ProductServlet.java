package servlet;

import domain.Category;
import domain.PageBean;
import domain.Product;
import net.sf.json.JSONObject;
import service.ProductService;
import service.impl.ProductServiceImp;
import utils.MyBeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    public String getCnamebyCid(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Category category = MyBeanUtils.populate(Category.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        category = productService.getCategorybyCid(category.getCid());
        String jsonStr = JSONObject.fromObject(category).toString();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonStr);
        return null;
    }

    public String findByCid(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Category category = MyBeanUtils.populate(Category.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        int pageNumber = 1 ;
        if(req.getParameter("pageNumber")!=null){
            pageNumber = Integer.valueOf(req.getParameter("pageNumber"));
        }
        int pageSize = 12;
        if(req.getParameter("pageSize")!=null){
            pageSize = Integer.valueOf(req.getParameter("pageSize"));
        }
        int totalRecord = productService.findByCid(category.getCid()).size();

        PageBean<Product> pageBean = new PageBean<Product>(pageNumber,pageSize,totalRecord);

        List products =  productService.findPageByCid(category.getCid(),pageBean);
        pageBean.setData(products);
        req.setAttribute("pageBean", pageBean);

        return "jsp/product_list.jsp";
    }

}