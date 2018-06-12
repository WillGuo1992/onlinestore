package test;

import servlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 测试BaseServlet
 * @author: Will.Guo
 * @create: 2018-06-10 14:48
 **/
public class TestUserSevlet extends BaseServlet {
    public String findALl(HttpServletRequest req, HttpServletResponse resp){
        req.getParameter("123");
        System.out.println("findAll");
        return "index.jsp";
    }
}
