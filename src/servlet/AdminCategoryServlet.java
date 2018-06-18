package servlet;

import domain.Category;
import service.AdminCategoryServive;
import service.impl.AdminCategoryServiveImpl;
import utils.MyBeanUtils;
import utils.UUIDUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 后台分类管理
 * @author: Will.Guo
 * @create: 2018-06-18 15:15
 **/
public class AdminCategoryServlet extends BaseServlet {
    private AdminCategoryServive servive = new AdminCategoryServiveImpl();

    public String findAll(HttpServletRequest req, HttpServletResponse response) {
        List<Category> allCats = servive.findAll();
        req.setAttribute("allCats", allCats);
        return "/jsp/admin/category/list.jsp";
    }

    public String addCategoryUI(HttpServletRequest req, HttpServletResponse response) {
        return "/jsp/admin/category/add.jsp";
    }

    public String addCategory(HttpServletRequest req, HttpServletResponse response) {
        Category category = MyBeanUtils.populate(Category.class, req.getParameterMap());
        category.setCid(UUIDUtils.getUUID());
        servive.addCategory(category);
        return "/AdminCategoryServlet?method=findAll";
    }

    public String editUI(HttpServletRequest req, HttpServletResponse response) {
        Category category = MyBeanUtils.populate(Category.class, req.getParameterMap());
        category = servive.findByCname(category.getCname());
        req.setAttribute("category", category);
        return "/jsp/admin/category/edit.jsp";
    }

    public String edit(HttpServletRequest req, HttpServletResponse response) {
        Category category = MyBeanUtils.populate(Category.class, req.getParameterMap());
        servive.update(category);
        return "/AdminCategoryServlet?method=findAll";
    }

    public String deleteCat(HttpServletRequest req, HttpServletResponse response) {
        Category category = MyBeanUtils.populate(Category.class, req.getParameterMap());
        servive.delete(category);
        return "/AdminCategoryServlet?method=findAll";
    }
}