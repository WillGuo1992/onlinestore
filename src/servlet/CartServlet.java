package servlet;

import domain.Cart;
import domain.Product;
import service.ProductService;
import service.impl.ProductServiceImp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description: 购物车servlet
 * @author: Will.Guo
 * @create: 2018-06-14 23:22
 **/
public class CartServlet extends BaseServlet{
    public String addToCart(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String pid = req.getParameter("pid");
        String tempCount = req.getParameter("count");

        ProductService productService = new ProductServiceImp();
        Product product = productService.findbyid(pid);
        int count =1 ;
        if (tempCount != null) {
            count = Integer.valueOf(tempCount);
        }

        Cart cart = getCart(req.getSession());
        cart.addCart(product, count);
        req.getSession().setAttribute("cart", cart);
        response.sendRedirect("/jsp/cart.jsp");
        return null;
    }

    public String deleteOneItem(HttpServletRequest req, HttpServletResponse response) throws IOException {
        String pid = req.getParameter("pid");
        Cart cart = getCart(req.getSession());
        cart.removeOneItem(pid);
        req.getSession().setAttribute("cart", cart);
        response.sendRedirect("/jsp/cart.jsp");
        return null;
    }

    public String deleteAll(HttpServletRequest req, HttpServletResponse response) throws IOException {
        Cart cart = getCart(req.getSession());
        cart.removeAll();
        req.getSession().setAttribute("cart", cart);
        response.sendRedirect("/jsp/cart.jsp");
        return null;
    }

    public Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }


}
