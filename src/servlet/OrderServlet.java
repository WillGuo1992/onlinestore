package servlet;

import domain.*;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.UUIDUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Date;

/**
 * @description: 订单Servlet
 * @author: Will.Guo
 * @create: 2018-06-15 16:06
 **/
public class OrderServlet extends BaseServlet {
    public String saveorder(HttpServletRequest req, HttpServletResponse response) throws SQLException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        Order order = new Order();
        order.setOid(UUIDUtils.getUUID());
        order.setState(1);
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setUser(user);

        for (CartItem item : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getUUID());
            orderItem.setCount(item.getCount());
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setSubtotal(item.getItemTotal());
            order.getList().add(orderItem);
        }

        OrderService orderService = new OrderServiceImpl();
        orderService.save(order);

        cart.removeAll();
        System.out.println(order.getList().size());
        req.setAttribute("order", order);
        return "jsp/order_info.jsp";
    }
}
