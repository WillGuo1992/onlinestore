package servlet;

import domain.Category;
import domain.PageBean;
import domain.Product;
import service.AdminProductService;
import service.ProductService;
import service.impl.AdminProductServiceImpl;
import service.impl.ProductServiceImp;
import utils.MyBeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 后台商品管理
 * @author: Will.Guo
 * @create: 2018-06-18 23:27
 **/
public class AdminProductServlet extends BaseServlet {
    private AdminProductService service = new AdminProductServiceImpl();

    public String findAllProductsWithPage(HttpServletRequest req, HttpServletResponse response) {
        String numStr = req.getParameter("num");
        int num = 1;
        int pageSize = 12;
        if (numStr != null) {
            num = Integer.valueOf(numStr);
        }
        int totalRecord = service.findAllCount();
        PageBean<Product> pageBean = new PageBean<>(num, pageSize, totalRecord);
        List<Product> products = service.findByPage(pageBean.getStartIndex(), pageBean.getPageSize(), 0);
        pageBean.setData(products);
        pageBean.setUrl("/AdminProductServlet?method=findAllProductsWithPage");
        req.setAttribute("page", pageBean);
        return "jsp/admin/product/list.jsp";
    }

    public String addUI(HttpServletRequest req, HttpServletResponse response) {
        List<Category> list = service.findAllCategory();
        req.setAttribute("list", list);
        return "jsp/admin/product/add.jsp";
    }

    public String add(HttpServletRequest req, HttpServletResponse response) {
        List<Category> list = service.findAllCategory();
        req.setAttribute("list", list);
        return "/AdminProductServlet?method=findAllProductsWithPage";
    }

    public String editUI(HttpServletRequest req, HttpServletResponse response) {
        Product product = MyBeanUtils.populate(Product.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        product = productService.findbyid(product.getPid());
        req.setAttribute("model", product);
        List<Category> list = service.findAllCategory();
        req.setAttribute("list", list);
        return "jsp/admin/product/edit.jsp";
    }

    public String offshow(HttpServletRequest req, HttpServletResponse response) {
        Product product = MyBeanUtils.populate(Product.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        productService.offShow(product.getPid(), 1);
        return "/AdminProductServlet?method=findAllProductsWithPage";
    }

    public String pushDownUI(HttpServletRequest req, HttpServletResponse response) {
        ProductService productService = new ProductServiceImp();
        List<Product> list =  productService.findAllByPflag(1);
        req.setAttribute("list", list);
        return "jsp/admin/product/pushDown_list.jsp";
    }
    public String pushUp(HttpServletRequest req, HttpServletResponse response) {
        Product product = MyBeanUtils.populate(Product.class, req.getParameterMap());
        ProductService productService = new ProductServiceImp();
        productService.offShow(product.getPid(), 0);
        List<Product> list =  productService.findAllByPflag(1);
        req.setAttribute("list", list);
        return "/AdminProductServlet?method=pushDownUI";
    }
}