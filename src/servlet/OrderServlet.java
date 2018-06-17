package servlet;

import com.sun.org.apache.xpath.internal.operations.Or;
import domain.*;
import org.omg.CORBA.ORB;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.MyBeanUtils;
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

    OrderService orderService = new OrderServiceImpl();

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


        orderService.save(order);

//        cart.removeAll();
        req.setAttribute("order", order);
        return "jsp/order_info.jsp";
    }

    public String payOrder(HttpServletRequest req, HttpServletResponse resp) {
        Order orderGet = MyBeanUtils.populate(Order.class, req.getParameterMap());
        Order order = orderService.findOrderBtOid(orderGet.getOid());
        order.setAddress(orderGet.getAddress());
        order.setName(orderGet.getName());
        order.setTelephone(orderGet.getTelephone());
        order.setState(2);

        orderService.updateOrderByOid(order);

        //第三方支付


        return null;
    }
}
